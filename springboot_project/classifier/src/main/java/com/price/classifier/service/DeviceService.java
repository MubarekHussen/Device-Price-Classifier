package com.price.classifier.service;

import com.price.classifier.model.Device;
import com.price.classifier.model.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DeviceService {

    private static final Logger logger = LoggerFactory.getLogger(DeviceService.class);

    private final DeviceRepository deviceRepository;
    private final RestTemplate restTemplate;
    private final String pythonApiUrl = "http://127.0.0.1:8000/predict/"; // Consider moving this to application's
                                                                          // configuration

    @Autowired
    public DeviceService(DeviceRepository deviceRepository, RestTemplateBuilder restTemplateBuilder) {
        this.deviceRepository = deviceRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * Gets all devices.
     *
     * @return a list of all devices
     */
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    /**
     * Gets a device by its ID.
     *
     * @param id the ID of the device
     * @return the device, or Optional.empty() if not found
     */
    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    /**
     * Adds a new device.
     *
     * @param device the device to add
     * @return the added device
     */
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    /**
     * Predicts the price of a device.
     *
     * @param device the device to predict the price for
     * @return the predicted price
     * @throws RuntimeException if an error occurred while sending request to Python
     *                          API
     */
    public int predictPrice(Device device) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Device> requestEntity = new HttpEntity<>(device, headers);

        logger.info("Sending device data to Python API: " + device.toString());

        try {
            ResponseEntity<Map> responseEntity = restTemplate.postForEntity(
                    pythonApiUrl + device.getId(),
                    requestEntity,
                    Map.class);

            logger.info("Received response from Python API: " + responseEntity);

            if (responseEntity != null && responseEntity.getBody() != null) {
                int predictedPriceRange = (Integer) responseEntity.getBody().get("predicted_price_range");
                device.setPriceRange(predictedPriceRange);
                logger.info("Predicted price range received from Python API: " + predictedPriceRange);

                Optional<Device> optionalDevice = deviceRepository.findById(device.getId());
                if (optionalDevice.isPresent()) {
                    Device existingDevice = optionalDevice.get();
                    existingDevice.setPriceRange(predictedPriceRange);
                    deviceRepository.save(existingDevice);
                } else {
                    deviceRepository.save(device);
                }

                return predictedPriceRange;
            } else {
                logger.error("Response from Python API was null or empty.");
                throw new RuntimeException("Response from Python API was null or empty.");
            }
        } catch (Exception e) {
            logger.error("Error occurred while sending request to Python API: ", e);
            throw new RuntimeException("Error occurred while sending request to Python API: ", e);
        }
    }
}
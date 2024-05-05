package com.price.classifier.service;

import com.price.classifier.model.Device;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Collections;
import java.util.Optional;
import java.util.Map;

@Service
public class DeviceService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Device> getAllDevices() {
        return Collections.emptyList();
    }

    public Optional<Device> getDeviceById(Long id) {
        return Optional.empty();
    }

    public Device addDevice(Device device) {
        return device;
    }

    public int predictPrice(Device device) {
        HttpEntity<Device> requestEntity = new HttpEntity<>(device);

        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(
                "http://localhost:8000/predict/" + device.getId(),
                requestEntity,
                Map.class
        );

        int predictedPriceRange = (Integer) responseEntity.getBody().get("predicted_price_range");

        device.setPriceRange(predictedPriceRange);

        return predictedPriceRange;
    }
}
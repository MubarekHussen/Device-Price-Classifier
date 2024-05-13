package com.price.classifier.controller;

import com.price.classifier.model.Device;
import com.price.classifier.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller for predicting device prices.
 */
@RestController
public class PredictController {

    private final DeviceService deviceService;

    /**
     * Constructs a new PredictController with the given DeviceService.
     *
     * @param deviceService the DeviceService to use for predicting device prices
     */
    @Autowired
    public PredictController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /**
     * Predicts the price of a device.
     *
     * @param deviceId the ID of the device
     * @param device   the device data
     * @return the predicted price
     */
    @PostMapping("/api/predict/{deviceId}")
    public ResponseEntity<Double> predictPrice(@PathVariable Long deviceId, @RequestBody Device device) {
        double predictedPrice = deviceService.predictPrice(device);
        return new ResponseEntity<>(predictedPrice, HttpStatus.OK);
    }
}
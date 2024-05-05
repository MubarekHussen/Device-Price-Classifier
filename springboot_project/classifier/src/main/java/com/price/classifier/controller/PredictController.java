package com.price.classifier.controller;

import com.price.classifier.model.Device;
import com.price.classifier.service.DeviceService;

import com.price.classifier.service.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PredictController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/api/predict/{deviceId}")
    public ResponseEntity<Double> predictPrice(@PathVariable Long deviceId, @RequestBody Device device) {
        double predictedPrice = deviceService.predictPrice(device);
        return new ResponseEntity<>(predictedPrice, HttpStatus.OK);
    }
}

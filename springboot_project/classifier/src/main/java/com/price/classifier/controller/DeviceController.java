package com.price.classifier.controller;

import com.price.classifier.model.Device;
import com.price.classifier.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("")
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") Long id) {
        Optional<Device> deviceOptional = deviceService.getDeviceById(id);
        if (deviceOptional.isPresent()) {
            return new ResponseEntity<>(deviceOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device newDevice = deviceService.addDevice(device);
        return new ResponseEntity<>(newDevice, HttpStatus.CREATED);
    }
}
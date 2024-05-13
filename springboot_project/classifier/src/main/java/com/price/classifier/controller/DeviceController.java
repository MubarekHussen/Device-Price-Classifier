package com.price.classifier.controller;

import com.price.classifier.model.Device;
import com.price.classifier.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Controller for managing devices.
 */
@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService deviceService;

    /**
     * Constructs a new DeviceController with the given DeviceService.
     *
     * @param deviceService the DeviceService to use for managing devices
     */
    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    /**
     * Gets all devices.
     *
     * @return a list of all devices
     */
    @GetMapping("")
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    /**
     * Gets a device by its ID.
     *
     * @param id the ID of the device
     * @return the device, or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") Long id) {
        Optional<Device> deviceOptional = deviceService.getDeviceById(id);
        if (deviceOptional.isPresent()) {
            return new ResponseEntity<>(deviceOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Adds a new device.
     *
     * @param device the device to add
     * @return the added device
     */
    @PostMapping("/")
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device newDevice = deviceService.addDevice(device);
        return new ResponseEntity<>(newDevice, HttpStatus.CREATED);
    }
}
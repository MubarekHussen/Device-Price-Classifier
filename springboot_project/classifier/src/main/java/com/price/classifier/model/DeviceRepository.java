package com.price.classifier.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for performing CRUD operations on Device entities.
 */
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
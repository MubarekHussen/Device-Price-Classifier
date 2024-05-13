package com.price.classifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class ClassifierApplication {

    /**
     * Main method which serves as the entry point for the JVM. Delegates to Spring
     * Boot's SpringApplication class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ClassifierApplication.class, args);
    }

}
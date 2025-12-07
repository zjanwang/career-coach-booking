// src/main/java/org/example/careercoach/CareerCoachApplication.java
package org.example.careercoach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class CareerCoachApplication {
    public static void main(String[] args) {
        SpringApplication.run(CareerCoachApplication.class, args);
    }
}

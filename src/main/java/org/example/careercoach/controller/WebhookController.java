// src/main/java/org/example/careercoach/controller/WebhookController.java
package org.example.careercoach.controller;

import org.example.careercoach.dto.WebhookEvent;
import org.example.careercoach.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhook")
public class WebhookController {

    @Autowired
    private WebhookService webhookService;

    @PostMapping("/cal")
    public ResponseEntity<String> handleCalWebhook(@RequestBody WebhookEvent event) {
        try {
            webhookService.processEvent(event);
            return ResponseEntity.ok("Event processed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing event: " + e.getMessage());
        }
    }
}

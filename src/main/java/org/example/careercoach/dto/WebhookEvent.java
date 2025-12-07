// src/main/java/org/example/careercoach/dto/WebhookEvent.java
package org.example.careercoach.dto;

import java.time.LocalDateTime;

public class WebhookEvent {
    private String type;
    private EventPayload payload;

    // Constructors
    public WebhookEvent() {}

    public WebhookEvent(String type, EventPayload payload) {
        this.type = type;
        this.payload = payload;
    }

    // Getters and Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public EventPayload getPayload() { return payload; }
    public void setPayload(EventPayload payload) { this.payload = payload; }

    public static class EventPayload {
        private String userId;
        private String coachId;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private String bookingId;

        // Constructors
        public EventPayload() {}

        // Getters and Setters
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }

        public String getCoachId() { return coachId; }
        public void setCoachId(String coachId) { this.coachId = coachId; }

        public LocalDateTime getStartTime() { return startTime; }
        public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

        public LocalDateTime getEndTime() { return endTime; }
        public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

        public String getBookingId() { return bookingId; }
        public void setBookingId(String bookingId) { this.bookingId = bookingId; }
    }
}

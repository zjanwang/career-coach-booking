// src/main/java/org/example/careercoach/dto/BookingDetailDTO.java
package org.example.careercoach.dto;

import org.example.careercoach.enums.BookingStatus;
import java.time.LocalDateTime;

public class BookingDetailDTO {
    private String coachName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingStatus status;

    // Constructors
    public BookingDetailDTO() {}
    // Getters and Setters
    public String getCoachName() { return coachName; }
    public void setCoachName(String coachName) { this.coachName = coachName; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }

}

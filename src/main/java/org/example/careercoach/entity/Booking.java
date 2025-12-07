// src/main/java/org/example/careercoach/entity/Booking.java
package org.example.careercoach.entity;

import org.example.careercoach.enums.BookingStatus;
import java.time.LocalDateTime;

public class Booking {
    private String uid;  // 新增：使用uid作为主键
    private String userId;
    private String coachId;  // 修改：使用coachId替代coachName和coachEmail
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingStatus status = BookingStatus.PENDING;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructors
    public Booking() {}

    public Booking(String userId) {
        this.userId = userId;
    }

    // Getters and Setters
    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getCoachId() { return coachId; }
    public void setCoachId(String coachId) { this.coachId = coachId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

// src/main/java/org/example/careercoach/service/WebhookService.java
package org.example.careercoach.service;

import org.example.careercoach.dto.WebhookEvent;
import org.example.careercoach.entity.Booking;
import org.example.careercoach.entity.Coach;
import org.example.careercoach.enums.BookingStatus;
import org.example.careercoach.repository.BookingRepository;
import org.example.careercoach.repository.CoachRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    private static final Logger log = LoggerFactory.getLogger(WebhookService.class);
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CoachRepository coachRepository;


    public void processEvent(WebhookEvent event) {
        switch (event.getType()) {
            case "BOOKING_CREATED":
                handleBookingCreated(event);
                break;
        }
    }

    private void handleBookingCreated(WebhookEvent event) {
        WebhookEvent.EventPayload payload = event.getPayload();

        // 验证教练是否存在
        Coach coach = coachRepository.findById(payload.getCoachId());
        if (coach == null) {
            throw new IllegalArgumentException("Coach not found with id: " + payload.getCoachId());
        }

        // 检查是否已经存在该预约
        Booking existingBooking = bookingService.getBookingByUid(payload.getBookingId());
        if (existingBooking != null) {
            // 如果已存在，则更新状态
            existingBooking.setStatus(BookingStatus.BOOKING_CREATED);
            existingBooking.setStartTime(payload.getStartTime());
            existingBooking.setEndTime(payload.getEndTime());
            existingBooking.setCoachId(payload.getCoachId()); // 设置 coachId
            bookingService.saveBooking(existingBooking);
        } else {
            // 创建新预约
            Booking booking = new Booking();
            booking.setUid(payload.getBookingId()); // 使用uid作为主键
            booking.setUserId(payload.getUserId());
            booking.setCoachId(payload.getCoachId()); // 使用 coachId
            booking.setStartTime(payload.getStartTime());
            booking.setEndTime(payload.getEndTime());
            booking.setStatus(BookingStatus.BOOKING_CREATED);
            bookingService.saveBooking(booking);
        }
    }

}

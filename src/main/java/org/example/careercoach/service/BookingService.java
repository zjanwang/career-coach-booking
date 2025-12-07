// src/main/java/org/example/careercoach/service/BookingService.java
package org.example.careercoach.service;

import org.example.careercoach.config.CalConfig;
import org.example.careercoach.dto.BookingDetailDTO;
import org.example.careercoach.entity.Booking;
import org.example.careercoach.entity.Coach;
import org.example.careercoach.repository.BookingRepository;
import org.example.careercoach.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private CalConfig calConfig;

    public String generateBookingUrl(String userId) {

        return calConfig.getBaseUrl();
    }

    public List<BookingDetailDTO> getUserBookings(String userId) {
        List<Booking> bookings = bookingRepository.findByUserId(userId);
        List<BookingDetailDTO> bookingDetails = new ArrayList<>();

        // 为每个booking获取对应的教练名称并包装成DTO
        for (Booking booking : bookings) {
            BookingDetailDTO detail = new BookingDetailDTO();
            detail.setStartTime(booking.getStartTime());
            detail.setEndTime(booking.getEndTime());
            detail.setStatus(booking.getStatus());
            // 获取教练名称
            if (booking.getCoachId() != null) {
                Coach coach = coachRepository.findById(booking.getCoachId());
                if (coach != null) {
                    detail.setCoachName(coach.getName());
                }
            }
            bookingDetails.add(detail);
        }
        return bookingDetails;
    }

    public String generateCancelUrl(String bookingId) {
        String baseUrl = calConfig.getCancelUrl();
        return baseUrl + "/" + bookingId + "?cancel=true";
    }

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public Booking getBookingByUid(String uid) {
        return bookingRepository.findByUid(uid);
    }

}

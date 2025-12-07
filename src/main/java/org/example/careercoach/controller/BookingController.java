// src/main/java/org/example/careercoach/controller/BookingController.java
package org.example.careercoach.controller;

import org.example.careercoach.dto.BookingDetailDTO;
import org.example.careercoach.entity.Booking;
import org.example.careercoach.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking-url")
    public ResponseEntity<Map<String, String>> getBookingUrl(@RequestParam String userId) {
        String url = bookingService.generateBookingUrl(userId);
        Map<String, String> response = new HashMap<>();
        response.put("url", url);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDetailDTO>> getUserBookings(@RequestParam String userId) {
        List<BookingDetailDTO> bookings = bookingService.getUserBookings(userId);
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/bookings/cancel")
    public ResponseEntity<Map<String, String>> cancelBooking(
            @RequestParam String bookingId,
            @RequestParam String userId) {
        // 直接通过bookingId和userId查询，而不是获取所有预订后再过滤
        Booking booking = bookingService.getBookingByUid(bookingId);

        if (booking == null || !booking.getUserId().equals(userId)) {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Invalid bookingId for the given userId");
            return ResponseEntity.badRequest().body(response);
        }

        String url = bookingService.generateCancelUrl(bookingId);
        Map<String, String> response = new HashMap<>();
        response.put("url", url);
        return ResponseEntity.ok(response);
    }
}

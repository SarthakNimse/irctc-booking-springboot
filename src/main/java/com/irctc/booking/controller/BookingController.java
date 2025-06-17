package com.irctc.booking.controller;

import com.irctc.booking.entity.Booking;
import com.irctc.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(
            @RequestParam int userId,
            @RequestParam int trainId,
            @RequestParam int numberOfSeats
    ) {
        return ResponseEntity.ok(
                bookingService.createBooking(userId, trainId, numberOfSeats)
        );
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
}

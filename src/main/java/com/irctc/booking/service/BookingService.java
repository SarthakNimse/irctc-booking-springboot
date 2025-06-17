package com.irctc.booking.service;

import com.irctc.booking.entity.Booking;
import com.irctc.booking.entity.Train;
import com.irctc.booking.entity.User;
import com.irctc.booking.repository.BookingRepository;
import com.irctc.booking.repository.TrainRepository;
import com.irctc.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking createBooking(int userId, int trainId, int numberOfSeats) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        Train train = trainRepository.findById(trainId).orElse(null);
        if (train == null) {
            throw new RuntimeException("Train not found with ID: " + trainId);
        }

        if (numberOfSeats > train.getTotalSeats()) {
            throw new RuntimeException("Not enough seats available for train ID: " + trainId);
        }

        // Update train seat count
        int updatedSeats = train.getTotalSeats() - numberOfSeats;
        train.setTotalSeats(updatedSeats);
        trainRepository.save(train);

        // Calculate fare
        float totalFare = train.getFare() * numberOfSeats;

        // Create booking
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setTrain(train);
        booking.setNumberOfSeat(numberOfSeats);
        booking.setTotalFare(totalFare);
        booking.setBookingTime(new Date()); // using java.util.Date instead of LocalDateTime

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(int id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking == null) {
            throw new RuntimeException("Booking not found with ID: " + id);
        }
        return booking;
    }
}


package com.nocountry.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nocountry.backend.dto.BookingDto;
import com.nocountry.backend.service.IBookingService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")

public class BookingController {

    private final IBookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<List<BookingDto>> getAll() {
        var bookings = bookingService.findAllBookings();
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        }
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Long bookingId) {
        return new ResponseEntity<>(bookingService.findBookingById(bookingId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        return new ResponseEntity<>(bookingService.saveBooking(bookingDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{bookingId}/update")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable Long bookingId,
            @RequestBody BookingDto bookingDto) {
        return new ResponseEntity<>(bookingService.updateBooking(bookingId, bookingDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{bookingId}/delete")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>("Booking successfully deleted", HttpStatus.ACCEPTED);
    }
}

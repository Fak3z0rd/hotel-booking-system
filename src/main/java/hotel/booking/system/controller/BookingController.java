package hotel.booking.system.controller;

import hotel.booking.system.exceptions.NotFoundException;
import hotel.booking.system.model.Booking;
import hotel.booking.system.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Optional<Booking> existingBooking = bookingService.getBookingById(id);
        if (existingBooking.isPresent()) {
            booking.setId(id);
            return bookingService.saveBooking(booking);
        } else {
            throw new NotFoundException("Booking not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBookingById(@PathVariable Long id) {
        bookingService.deleteBookingById(id);
    }

    // Outros métodos do controlador, se necessário
}


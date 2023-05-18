package hotel.booking.system.controller;

import hotel.booking.system.exceptions.NotFoundException;
import hotel.booking.system.model.Guest;
import hotel.booking.system.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public Optional<Guest> getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.saveGuest(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        Optional<Guest> existingGuest = guestService.getGuestById(id);
        if (existingGuest.isPresent()) {
            guest.setId(id);;
            return guestService.saveGuest(guest);
        } else {
            throw new NotFoundException("Guest not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteGuestById(@PathVariable Long id) {
        guestService.deleteGuestById(id);
    }

    // Outros métodos do controlador, se necessário
}


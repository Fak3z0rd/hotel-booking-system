package hotel.booking.system.controller;

import hotel.booking.system.model.Hotel;
import hotel.booking.system.service.HotelService;
import hotel.booking.system.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getHotelById(@PathVariable Long id)  {
        return hotelService.getHotelById(id);
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        Optional<Hotel> existingHotel = hotelService.getHotelById(id);
        if (existingHotel.isPresent()) {
            hotel.setId(id);
            return hotelService.saveHotel(hotel);
        } else {
            throw new NotFoundException("Hotel not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteHotelById(@PathVariable Long id) {
        hotelService.deleteHotelById(id);
    }
}

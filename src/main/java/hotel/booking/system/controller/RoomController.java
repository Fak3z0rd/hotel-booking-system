package hotel.booking.system.controller;

import hotel.booking.system.exceptions.NotFoundException;
import hotel.booking.system.model.Room;
import hotel.booking.system.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room room) {
        Optional<Room> existingRoom = roomService.getRoomById(id);
        if (existingRoom.isPresent()) {
            room.setId(id);
            return roomService.saveRoom(room);
        } else {
            throw new NotFoundException("Room not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable Long id) {
        roomService.deleteRoomById(id);
    }

}


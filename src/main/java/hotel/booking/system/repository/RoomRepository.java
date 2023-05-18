package hotel.booking.system.repository;

import hotel.booking.system.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}

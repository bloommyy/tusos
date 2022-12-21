package bg.dimps.tusos.repositories;

import bg.dimps.tusos.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAll();
    Room findRoomById(Long roomId);
    List<Room> findRoomsByDormID(String dormId);
    Room findRoomByDormIDAndRoomNumber(String dormId, Long roomNumber);
}

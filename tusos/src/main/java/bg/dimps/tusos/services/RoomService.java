package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RoomService {
    boolean saveRoom(Room room);
    boolean removeRoom(Room room);
    Room getRoomById(Long roomId);
    List<Room> getAllDormRooms(String dormId);
    List<Student> getRoomStudents(Long roomId);
    List<Furniture> getRoomFurniture(Long roomId);
    boolean addNewFurniture(Furniture furniture);
    boolean removeFurniture(Long furnitureId);
    boolean addNewElectricAppliance(ElectricAppliances electricAppliance);
    boolean removeElectricAppliance(Long electricApplianceId);
    void addStudent(String dormId,Long roomNumber, Student student);
    List<Room> getAllRooms();
    List<String> getAllAvailableDorms();
}

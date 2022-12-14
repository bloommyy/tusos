package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.*;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    boolean saveRoom(Room room);
    boolean removeRoom(Room room);
    Room getRoomById(Long roomId);
    List<Room> getAllDormRooms(Long dormId);
    List<Student> getRoomStudents(Long roomId);
    List<Furniture> getRoomFurniture(Long roomId);
    boolean addFurnitureType(FurnitureType furnitureType);
    boolean addNewFurniture(Long roomId, Furniture furniture, Long typeId);
    boolean removeFurniture(Long furnitureId);
    boolean addNewElectricAppliance(Long roomId, ElectricAppliances electricAppliance);
    boolean removeElectricAppliance(Long electricApplianceId);
    boolean addStudent(Long roomId, Student student);
}

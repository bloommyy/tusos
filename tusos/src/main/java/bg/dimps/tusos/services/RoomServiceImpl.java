package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.*;
import bg.dimps.tusos.repositories.ElectricApplianceRepository;
import bg.dimps.tusos.repositories.FurnitureRepository;
import bg.dimps.tusos.repositories.FurnitureTypeRepository;
import bg.dimps.tusos.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;
    private final FurnitureTypeRepository furnitureTypeRepository;
    private final ElectricApplianceRepository electricApplianceRepository;
    private final FurnitureRepository furnitureRepository;

    public RoomServiceImpl(RoomRepository roomRepository, FurnitureTypeRepository furnitureTypeRepository, ElectricApplianceRepository electricApplianceRepository, FurnitureRepository furnitureRepository) {
        this.roomRepository = roomRepository;
        this.furnitureTypeRepository = furnitureTypeRepository;
        this.electricApplianceRepository = electricApplianceRepository;
        this.furnitureRepository = furnitureRepository;
    }

    @Override
    public boolean saveRoom(Room room) {
        if (room != null){
            roomRepository.save(room);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeRoom(Room room) {
        if (room != null){
            roomRepository.delete(room);
            return true;
        }
        return false;
    }

    @Override
    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    @Override
    public List<Room> getAllDormRooms(Long dormId) {
        return roomRepository.findRoomsByDormID(dormId);
    }

    @Override
    public List<Student> getRoomStudents(Long roomId) {
        Room currentRoom = getRoomById(roomId);
        return currentRoom.getStudents();
    }

    @Override
    public List<Furniture> getRoomFurniture(Long roomId) {
        Room currentRoom = getRoomById(roomId);
        return currentRoom.getFurnitures();
    }

    @Override
    public boolean addFurnitureType(FurnitureType furnitureType) {
        furnitureTypeRepository.save(furnitureType);
        return true;
    }

    @Override
    public boolean addNewFurniture(Long roomId, Furniture furniture, FurnitureType furnitureType) {
        if (furniture != null && furnitureType != null){
            furniture.setType(furnitureType);
            furnitureRepository.save(furniture);
            Room currentRoom = getRoomById(roomId);
            currentRoom.addFurniture(furniture);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeFurniture(Long furnitureId) {
        Furniture toRemove = furnitureRepository.findFurnitureByFurnitureID(furnitureId);
        if (toRemove != null){
            furnitureRepository.delete(toRemove);
            return true;
        }
        return false;
    }

    @Override
    public boolean addNewElectricAppliance(Long roomId, ElectricAppliances electricAppliance) {
        if (electricAppliance!=null){
            electricApplianceRepository.save(electricAppliance);
            Room currentRoom = getRoomById(roomId);
            currentRoom.addElectricAppliance(electricAppliance);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeElectricAppliance(Long electricApplianceId) {
        ElectricAppliances toRemove = electricApplianceRepository.findElectricAppliancesByApplianceID(electricApplianceId);
        if (toRemove != null){
            electricApplianceRepository.delete(toRemove);
            return true;
        }
        return false;
    }

    @Override
    public boolean addStudent(Long roomId, Student student) {
        if (student != null){
            Room currentRoom = getRoomById(roomId);
            currentRoom.getStudents().add(student);
            return true;
        }
        return false;
    }


}

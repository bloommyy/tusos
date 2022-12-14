package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.*;
import bg.dimps.tusos.services.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    //pre authorize (has role host)
    @GetMapping("/fetch")
    public ResponseEntity<?> getAllRoomsInDorm(Long dormId){
        List<Room> rooms = roomService.getAllDormRooms(dormId);
        return ResponseEntity.ok(rooms);
    }

    //pre authorize (has role host)
    @PostMapping("/addRoom")
    public ResponseEntity<?> addRoom(Long dormId, @RequestBody Room room){
        if (room != null){
            room.setDormID(dormId);
            roomService.saveRoom(room);
            return ResponseEntity.ok("Room added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    //pre authorize (has role host)
    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(Long roomId, @RequestBody Student student){
        Room currentRoom = roomService.getRoomById(roomId);
        if (currentRoom != null && student != null){
            roomService.addStudent(roomId, student);
            return ResponseEntity.ok("Student added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    //pre authorize (has role host)
    @PostMapping("/addFurnitureType")
    public ResponseEntity<?> addFurnitureType(@RequestBody FurnitureType furnitureType){
        if (furnitureType != null){
            roomService.addFurnitureType(furnitureType);
            return ResponseEntity.ok("Furniture type added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    //pre authorize (has role host or student)
    @PostMapping("/addFurniture")
    public ResponseEntity<?> addFurniture(Long roomId, Long typeId, @RequestBody Furniture furniture){
        if (furniture != null){
            roomService.addNewFurniture(roomId, furniture, typeId);
            return ResponseEntity.ok("Furniture added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    //pre authorize (has role host or student)
    @DeleteMapping("/removeFurniture")
    public ResponseEntity<?> removeFurniture(Long furnitureId){
        if (roomService.removeFurniture(furnitureId)){
            return ResponseEntity.ok("Furniture removed successfully");
        }
        return ResponseEntity.badRequest().body("Cannot remove item");
    }

    //pre authorize (has role host or student)
    @PostMapping("/addElectricAppliance")
    public ResponseEntity<?> addElectricAppliance(Long roomId, @RequestBody ElectricAppliances electricAppliance){
        if (electricAppliance != null){
            roomService.addNewElectricAppliance(roomId, electricAppliance);
            return ResponseEntity.ok("ElectricAppliance added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    //pre authorize (has role host or student)
    @DeleteMapping("/removeElectricAppliance")
    public ResponseEntity<?> removeElectricAppliance(Long applianceId){
        if (roomService.removeElectricAppliance(applianceId)){
            return ResponseEntity.ok("Electric appliance removed successfully");
        }
        return ResponseEntity.badRequest().body("Cannot remove item");
    }


}

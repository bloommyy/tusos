package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.*;
import bg.dimps.tusos.security.pojos.request.BulkAddRequest;
import bg.dimps.tusos.services.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ROLE_HOST')")
    @GetMapping("/fetch")
    public ResponseEntity<?> getAllRoomsInDorm(Long dormId){
        List<Room> rooms = roomService.getAllDormRooms(dormId);
        return ResponseEntity.ok(rooms);
    }

    @PreAuthorize("hasRole('ROLE_HOST')")
    @PostMapping("/addRoom")
    public ResponseEntity<?> addRoom(Long dormId, @RequestBody Room room){
        if (room != null){
            room.setDormID(dormId);
            roomService.saveRoom(room);
            return ResponseEntity.ok("Room added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    @PreAuthorize("hasRole('ROLE_HOST')")
    @PostMapping("/addAllDormRooms")
    public ResponseEntity<?> addAllDormRooms(@RequestBody BulkAddRequest bulkAddRequest) {
        int totalNumCount = 0;
        try {
            if (!roomService.getAllDormRooms(bulkAddRequest.getDormId()).isEmpty())
                throw new Exception("Съществува поне една стая в този блок.");

            for (Long floor = 0L; floor < bulkAddRequest.getFloorCount(); floor++) {
                for (Long roomNumber = 1L; roomNumber <= bulkAddRequest.getRoomsPerFloorCount(); roomNumber++) {
                    Long processedRoomNumber = floor * 100 + roomNumber;
                    roomService.saveRoom(new Room(bulkAddRequest.getDormId(), processedRoomNumber));
                    totalNumCount++;
                }
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Нещо се обърка. " + e.getMessage());
        }

        return ResponseEntity.ok(totalNumCount + " стаи упешно добавени!");
    }

    @PreAuthorize("hasRole('ROLE_HOST')")
    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(Long roomId, @RequestBody Student student){
        Room currentRoom = roomService.getRoomById(roomId);
        if (currentRoom != null && student != null){
            roomService.addStudent(roomId, student);
            return ResponseEntity.ok("Student added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }


    @PreAuthorize("hasRole('ROLE_HOST') or hasRole('ROLE_STUDENT')")
    @PostMapping("/addFurniture")
    public ResponseEntity<?> addFurniture(Long roomId, @RequestBody Furniture furniture){
        if (furniture != null){
            roomService.addNewFurniture(roomId, furniture);
            return ResponseEntity.ok("Furniture added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    @PreAuthorize("hasRole('ROLE_HOST') or hasRole('ROLE_STUDENT')")
    @DeleteMapping("/removeFurniture")
    public ResponseEntity<?> removeFurniture(Long furnitureId){
        if (roomService.removeFurniture(furnitureId)){
            return ResponseEntity.ok("Furniture removed successfully");
        }
        return ResponseEntity.badRequest().body("Cannot remove item");
    }

    @PreAuthorize("hasRole('ROLE_HOST') or hasRole('ROLE_STUDENT')")
    @PostMapping("/addElectricAppliance")
    public ResponseEntity<?> addElectricAppliance(Long roomId, @RequestBody ElectricAppliances electricAppliance){
        if (electricAppliance != null){
            roomService.addNewElectricAppliance(roomId, electricAppliance);
            return ResponseEntity.ok("ElectricAppliance added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    @PreAuthorize("hasRole('ROLE_HOST') or hasRole('ROLE_STUDENT')")
    @DeleteMapping("/removeElectricAppliance")
    public ResponseEntity<?> removeElectricAppliance(Long applianceId){
        if (roomService.removeElectricAppliance(applianceId)){
            return ResponseEntity.ok("Electric appliance removed successfully");
        }
        return ResponseEntity.badRequest().body("Cannot remove item");
    }


}

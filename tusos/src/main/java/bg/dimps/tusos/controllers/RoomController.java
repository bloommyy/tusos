package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.*;
import bg.dimps.tusos.pojos.AddFurnitureRequest;
import bg.dimps.tusos.pojos.ElectricApplianceRequest;
import bg.dimps.tusos.security.pojos.request.BulkAddRequest;
import bg.dimps.tusos.services.RoomService;
import bg.dimps.tusos.services.StudentService;
import bg.dimps.tusos.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    private final StudentService studentService;

    public RoomController(RoomService roomService, StudentService studentService) {
        this.roomService = roomService;
        this.studentService = studentService;
    }

    @PreAuthorize("hasRole('ROLE_HOST')")
    @GetMapping("/fetch")
    public ResponseEntity<?> getAllRoomsInDorm(Long dormId) {
        List<Room> rooms = roomService.getAllDormRooms(dormId);
        return ResponseEntity.ok(rooms);
    }

    @PreAuthorize("hasAnyRole('ROLE_HOST','ROLE_STUDENT')")
    @GetMapping("/fetchAllRooms")
    public ResponseEntity<?> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @PreAuthorize("hasRole('ROLE_HOST')")
    @PostMapping("/addRoom")
    public ResponseEntity<?> addRoom(@RequestBody Room room) {
        if (room != null) {
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
    public ResponseEntity<?> addStudent(Long roomId, @RequestBody Student student) {
        Room currentRoom = roomService.getRoomById(roomId);
        if (currentRoom != null && student != null) {
            roomService.addStudent(roomId, student);
            return ResponseEntity.ok("Student added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }


    @PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_HOST')")
    @PostMapping("/addFurniture")
    public ResponseEntity<?> addFurniture(@RequestBody AddFurnitureRequest request) {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Student currentStudent = studentService.getStudentByEmail(currentUserEmail);
        Long roomId = currentStudent.getRoom().getRoomNumber(); //TODO: Това тук после не е по roomNumber, а по ID?
        if (request != null) {
            Room room = roomService.getRoomById(roomId);
            System.out.println(room.getRoomNumber());
            roomService.addNewFurniture(new Furniture(room, request.getFurnitureName(), request.isBroken()));
            return ResponseEntity.ok("Furniture added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    @PreAuthorize("hasAnyRole('ROLE_STUDENT', 'ROLE_HOST')")
    @GetMapping("/getAllFurniture")
    public ResponseEntity<?> getAllRoomFurniture() {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Student currentStudent = studentService.getStudentByEmail(currentUserEmail);
        if (currentStudent.getRoom() == null)
            return ResponseEntity.badRequest().body("Не сте в стая!");

        Long roomId = currentStudent.getRoom().getRoomNumber();
        Room room = roomService.getRoomById(roomId);
        if (room != null){
            return ResponseEntity.ok(room.getFurnitures());
        }
        return ResponseEntity.badRequest().body("No room found");
    }

    @PreAuthorize("hasRole('ROLE_HOST') or hasRole('ROLE_STUDENT')")
    @DeleteMapping("/removeFurniture")
    public ResponseEntity<?> removeFurniture(Long furnitureId) {
        if (roomService.removeFurniture(furnitureId)) {
            return ResponseEntity.ok("Furniture removed successfully");
        }
        return ResponseEntity.badRequest().body("Cannot remove item");
    }

    @PreAuthorize("hasRole('ROLE_HOST') or hasRole('ROLE_STUDENT')")
    @PostMapping("/addElectricAppliance")
    public ResponseEntity<?> addElectricAppliance(@RequestBody ElectricApplianceRequest request) {
        String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Student currentStudent = studentService.getStudentByEmail(currentUserEmail);
        Long roomId = currentStudent.getRoom().getRoomNumber();
        if (request != null) {
            Room room = roomService.getRoomById(roomId);
            roomService.addNewElectricAppliance(new ElectricAppliances(room, request.getApplianceName()));
            return ResponseEntity.ok("ElectricAppliance added successfully!");
        }
        return ResponseEntity.badRequest().body("Cannot save null object");
    }

    @PreAuthorize("hasRole('ROLE_HOST') or hasRole('ROLE_STUDENT')")
    @DeleteMapping("/removeElectricAppliance")
    public ResponseEntity<?> removeElectricAppliance(Long applianceId) {
        if (roomService.removeElectricAppliance(applianceId)) {
            return ResponseEntity.ok("Electric appliance removed successfully");
        }
        return ResponseEntity.badRequest().body("Cannot remove item");
    }


}

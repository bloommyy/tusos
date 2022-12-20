package bg.dimps.tusos.entities;

import bg.dimps.tusos.security.pojos.request.BulkAddRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "room_number"),
        @UniqueConstraint(columnNames = "dorm_id")
})
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number")
    private Long roomNumber;

    @Column(name = "dorm_id")
    private Long dormID;

    @OneToMany(mappedBy = "room")
    private List<Student> students;

    @OneToMany(mappedBy = "room")
    private List<Furniture> furnitures;

    @OneToMany(mappedBy = "room")
    private List<ElectricAppliances> electricAppliances;

    private String description;

    public Room(Long roomNumber, List<Student> students, List<Furniture> furnitures, List<ElectricAppliances> electricAppliances, String description) {
        this.roomNumber = roomNumber;
        this.students = students;
        this.furnitures = furnitures;
        this.electricAppliances = electricAppliances;
        this.description = description;
    }

    public Room(Long dormID, Long roomNumber) {
        this.dormID = dormID;
        this.roomNumber = roomNumber;
        this.students = new ArrayList<>();
        this.furnitures = new ArrayList<>();
        this.electricAppliances = new ArrayList<>();
        this.description = "";
    }

    public Room() {
    }

    public Long getDormID() {
        return dormID;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setDormID(Long dormID) {
        this.dormID = dormID;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    public List<ElectricAppliances> getElectricAppliances() {
        return electricAppliances;
    }

    public void setElectricAppliances(List<ElectricAppliances> electricAppliances) {
        this.electricAppliances = electricAppliances;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addFurniture(Furniture furniture){
        furnitures.add(furniture);
    }
    public void removeFurniture(Furniture furniture){
        furnitures.remove(furniture);
    }
    public void addElectricAppliance(ElectricAppliances elAppliances){
        electricAppliances.add(elAppliances);
    }
    public void removeElectricAppliance(ElectricAppliances elAppliances){
        electricAppliances.remove(electricAppliances);
    }

}

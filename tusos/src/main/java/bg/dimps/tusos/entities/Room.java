package bg.dimps.tusos.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roomID;

    @Column(name = "dorm_id")
    private Long dormID;

    @OneToMany(mappedBy = "room")
    private List<Student> students;

    @OneToMany(mappedBy = "room")
    private List<Furniture> furnitures;

    @OneToMany(mappedBy = "room")
    private List<ElectricAppliances> electricAppliances;
    private String description;

    public Room(List<Student> students, List<Furniture> furnitures, List<ElectricAppliances> electricAppliances, String description) {
        this.students = students;
        this.furnitures = furnitures;
        this.electricAppliances = electricAppliances;
        this.description = description;
    }

    public Room() {
    }

    public Long getRoomID() {
        return roomID;
    }

    public Long getDormID() {
        return dormID;
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

    public void AddFruniture(Furniture furniture){

    }
    public void RemoveFurniture(Furniture furniture){

    }
    public void AddElectricAppliance(ElectricAppliances elAppliances){

    }
    public void RemoveElectricAppliance(ElectricAppliances elAppliances){

    }

}

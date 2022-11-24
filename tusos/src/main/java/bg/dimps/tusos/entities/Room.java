package bg.dimps.tusos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long roomID;
    private Long dormID;
    private List<Student> students;
    private List<Furniture> furnitures;
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

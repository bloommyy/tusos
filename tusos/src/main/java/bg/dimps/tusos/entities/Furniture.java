package bg.dimps.tusos.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long furnitureID;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private String furnitureName;

    private boolean isBroken;

    public Furniture(Room room, String furnitureName, boolean isBroken) {
        this.room = room;
        this.furnitureName = furnitureName;
        this.isBroken = isBroken;
    }

    public Furniture() {
    }

    public Long getFurnitureID() {
        return furnitureID;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public void ChangeRoom(Room room){
        setRoom(room);
    }
    public void ChangeState(boolean isBroken){
        setBroken(isBroken);
    }
}

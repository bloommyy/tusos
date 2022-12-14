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

    @ManyToOne
    @JoinColumn(name = "type_id")
    private FurnitureType type;
    private boolean isBroken;

    public Furniture(Room room, FurnitureType type, boolean isBroken) {
        this.room = room;
        this.type = type;
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

    public FurnitureType getType() {
        return type;
    }

    public void setType(FurnitureType type) {
        this.type = type;
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

package bg.dimps.tusos.entities;

import javax.persistence.*;

@Entity
public class ElectricAppliances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long applienceID;
    @ManyToOne
    @JoinColumn(name = "room_room_id")
    private Room room;
    private String name;

    public ElectricAppliances() {
    }

    public ElectricAppliances(Room room, String name) {
        this.room = room;
        this.name = name;
    }

    public Long getApplienceID() {
        return applienceID;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

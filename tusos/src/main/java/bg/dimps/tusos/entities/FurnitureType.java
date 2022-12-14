package bg.dimps.tusos.entities;

import javax.persistence.*;

@Entity
public class FurnitureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FurnitureType(String name) {
        this.name = name;
    }

    public FurnitureType() {
    }
}

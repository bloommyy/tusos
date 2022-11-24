package bg.dimps.tusos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FurnitureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long type;
    private String name;

    public Long getType() {
        return type;
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

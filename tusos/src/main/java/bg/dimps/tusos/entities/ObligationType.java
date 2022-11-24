package bg.dimps.tusos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ObligationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer type;
    private String name;

    public ObligationType() {
    }

    public ObligationType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

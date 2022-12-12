package bg.dimps.tusos.entities;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Host extends User {
    @JoinColumn(name = "dorm_id")
    private Long dormId;

    public Long getDormId() {
        return dormId;
    }

    public void setDormId(Long dormId) {
        this.dormId = dormId;
    }

    public Host(Long id, String firstName, String middleName, String lastName, String phoneNumber, String email, String password, Set<Role> roles, Long dormId) {
        super(id, firstName, middleName, lastName, phoneNumber, email, password, roles);
        this.dormId = dormId;
    }

    public Host() {
    }
}

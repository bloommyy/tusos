package bg.dimps.tusos.entities;

import bg.dimps.tusos.security.pojos.request.HostSignupRequest;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Host extends User {
    @JoinColumn(name = "dorm_id")
    private String dormId;

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public Host(Long id, String firstName, String middleName, String lastName, String phoneNumber, String email, String password, Set<Role> roles, String dormId) {
        super(id, firstName, middleName, lastName, phoneNumber, email, password, roles);
        this.dormId = dormId;
    }

    public Host(HostSignupRequest hostSignupRequest, String password) {
        super(hostSignupRequest, password);
        this.dormId = hostSignupRequest.getDormID();
    }

    public Host() {
    }
}

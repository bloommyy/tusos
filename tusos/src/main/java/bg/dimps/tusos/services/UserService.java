package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.security.pojos.request.UserSignupRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserService {
    void checkExistenceByEmail(String email);
    void validateRequest(UserSignupRequest userSignupRequest);
    void setRoles(User user, Set<String> strRoles);
}

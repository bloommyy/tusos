package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.security.pojos.request.UserSignupRequest;

import java.util.Set;

public interface UserService {
    String checkRequest(UserSignupRequest studentSignupRequest);
    void setRoles(User user, Set<String> strRoles);
}

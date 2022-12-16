package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.security.pojos.request.UserSignupRequest;

import java.util.Set;

public interface UserService {
    String checkRequest(UserSignupRequest studentSignupRequest);
    void validateStudent(String email, String password, String firstName, String middleName, String lastName, String phoneNumber, String facultyNumber, String repeatedPassword);
    void setRoles(User user, Set<String> strRoles);
}

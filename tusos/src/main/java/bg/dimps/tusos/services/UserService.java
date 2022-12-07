package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.security.pojos.request.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void saveUser(SignupRequest signupRequest);
    Student getStudent(String facultyNumber);
}

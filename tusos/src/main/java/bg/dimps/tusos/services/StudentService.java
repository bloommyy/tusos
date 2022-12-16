package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.security.pojos.request.StudentSignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends UserService{
    void validateStudent(String email, String password, String firstName, String middleName, String lastName, String facultyNumber, String phoneNumber, String repeatedPassword);

    void saveStudent(StudentSignupRequest studentSignupRequest);
    Student getStudent(String facultyNumber);
}

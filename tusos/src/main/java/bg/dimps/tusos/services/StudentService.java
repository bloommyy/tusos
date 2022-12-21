package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.security.pojos.request.StudentSignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends UserService{
    void validateRequest(StudentSignupRequest studentSignupRequest);
    void saveStudent(StudentSignupRequest studentSignupRequest);
    Student getStudent(String facultyNumber);
    Student getStudentByEmail(String email);
}

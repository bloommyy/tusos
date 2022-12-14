package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.security.pojos.request.StudentSignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends UserService{
    void saveStudent(StudentSignupRequest studentSignupRequest);
    Student getStudent(String facultyNumber);
}

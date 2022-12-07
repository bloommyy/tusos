package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Role;
import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.repositories.StudentRepository;
import bg.dimps.tusos.security.pojos.request.SignupRequest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class UserServiceImpl implements UserService{

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(SignupRequest signupRequest) {
        Student student = new Student(signupRequest, passwordEncoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();
    }

    @Override
    public Student getStudent(String facultyNumber) {
        return studentRepository.findStudentByFacultyNumber(facultyNumber).get();
    }


}

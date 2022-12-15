package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.repositories.RoleRepository;
import bg.dimps.tusos.repositories.UserRepository;
import bg.dimps.tusos.security.pojos.request.StudentSignupRequest;
import bg.dimps.tusos.security.pojos.request.UserSignupRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentServiceImpl extends UserServiceImpl implements StudentService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public StudentServiceImpl(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        super(roleRepository);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveStudent(StudentSignupRequest studentSignupRequest) {
        Student student = new Student(studentSignupRequest, passwordEncoder.encode(studentSignupRequest.getPassword()));

        Set<String> strRoles = studentSignupRequest.getRole();
        setRoles(student, strRoles);

        userRepository.save(student);
    }

    @Override
    public Student getStudent(String email) {
        return (Student)userRepository.findUserByEmail(email).get();
    }

    @Override
    public String checkRequest(UserSignupRequest studentSignupRequest) {
        if (userRepository.existsByEmail(studentSignupRequest.getEmail())) {
            return "Email is already taken!";
        }
        return "ok";
    }
}

package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.repositories.RoleRepository;
import bg.dimps.tusos.repositories.UserRepository;
import bg.dimps.tusos.security.pojos.request.StudentSignupRequest;
import bg.dimps.tusos.utils.Validations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

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
    public void validateRequest(StudentSignupRequest studentSignupRequest) {
        super.validateRequest(studentSignupRequest);

        if(!Validations.validateFacultyNumber(studentSignupRequest.getFacultyNum()))
            throw new RuntimeException("Invalid faculty number");
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
    public Student getStudentByEmail(String email) {
        Optional<Student> student = userRepository.findByEmail(email);
        if (student.isPresent())
            return student.get();

        return null;
    }

    @Override
    public void checkExistenceByEmail(String email) {
        if (userRepository.existsByEmail(email))
            throw new RuntimeException("Email is already taken!");
    }
}

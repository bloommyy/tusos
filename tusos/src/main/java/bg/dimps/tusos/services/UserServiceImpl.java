package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Role;
import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.repositories.UserRepository;
import bg.dimps.tusos.security.pojos.request.SignupRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(SignupRequest signupRequest) {
        Student student = new Student(signupRequest, passwordEncoder.encode(signupRequest.getPassword()));
        userRepository.save(student);
    }

    @Override
    public Student getStudent(String email) {
        return userRepository.findStudentByEmail(email).get();
    }

    @Override
    public String checkRequest(SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return "Email is already taken!";
        }
        return "ok";
    }


}

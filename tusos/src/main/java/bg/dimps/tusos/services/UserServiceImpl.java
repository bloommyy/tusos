package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.ERole;
import bg.dimps.tusos.entities.Role;
import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.RoleRepository;
import bg.dimps.tusos.repositories.UserRepository;
import bg.dimps.tusos.security.pojos.request.SignupRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(SignupRequest signupRequest) {
        Student user = new Student(signupRequest, passwordEncoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if ("host".equals(role)) {
                    Role adminRole = roleRepository.findByName(ERole.ROLE_HOST)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
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

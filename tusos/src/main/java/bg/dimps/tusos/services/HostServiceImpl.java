package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Host;
import bg.dimps.tusos.repositories.HostRepository;
import bg.dimps.tusos.repositories.RoleRepository;
import bg.dimps.tusos.security.pojos.request.HostSignupRequest;
import bg.dimps.tusos.security.pojos.request.UserSignupRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class HostServiceImpl extends UserServiceImpl implements HostService {

    private final HostRepository hostRepository;

    private final PasswordEncoder passwordEncoder;

    public HostServiceImpl(RoleRepository roleRepository, HostRepository hostRepository, PasswordEncoder passwordEncoder) {
        super(roleRepository);
        this.hostRepository = hostRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveHost(HostSignupRequest hostSignupRequest) {
        Host host = new Host(hostSignupRequest, passwordEncoder.encode(hostSignupRequest.getPassword()));

        Set<String> strRoles = hostSignupRequest.getRole();
        setRoles(host, strRoles);

        hostRepository.save(host);
    }

    @Override
    public Optional<Host> getHostById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public String checkRequest(UserSignupRequest studentSignupRequest) {
        if (hostRepository.existsByEmail(studentSignupRequest.getEmail())) {
            return "Email is already taken!";
        }
        return "ok";
    }

    @Override
    public void validateStudent(String email, String password, String firstName, String middleName, String lastName, String phoneNumber, String repeatedPassword, String requestRepeatedPassword)
    {
        if(!validations.validateEmail(email))
            throw new RuntimeException("Invalid email");
        if(!validations.validatePassword(password))
            throw new RuntimeException("Invalid password name");
        if(!validations.validateName(firstName))
            throw new RuntimeException("Invalid first name");
        if(!validations.validateName(middleName))
            throw new RuntimeException("Invalid middle name");
        if(!validations.validateName(lastName))
            throw new RuntimeException("Invalid last name");
        if(!validations.validatePhoneNumber(phoneNumber))
            throw new RuntimeException("Invalid phone number");
        if(!validations.validateRepeatedPassword(repeatedPassword))
            throw new RuntimeException("Invalid repeated password");
    }
}

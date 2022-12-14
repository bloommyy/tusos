package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Host;
import bg.dimps.tusos.entities.Student;
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
}

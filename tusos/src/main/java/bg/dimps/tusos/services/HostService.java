package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Host;
import bg.dimps.tusos.security.pojos.request.HostSignupRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface HostService extends UserService{
    void saveHost(HostSignupRequest hostSignupRequest);
    Optional<Host> getHostById(Long id);
}

package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Host;

import java.util.Optional;

public interface HostService {
    Optional<Host> getHostById(Long id);
}

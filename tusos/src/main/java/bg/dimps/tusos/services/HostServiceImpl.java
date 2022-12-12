package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.Host;
import bg.dimps.tusos.repositories.HostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HostServiceImpl implements HostService{
    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public Optional<Host> getHostById(Long id) {
        return hostRepository.findById(id);
    }
}

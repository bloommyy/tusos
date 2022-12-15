package bg.dimps.tusos.repositories;

import bg.dimps.tusos.entities.Host;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HostRepository extends JpaRepository<Host, Long> {
   Optional<Host> findById(Long hostId);

   Boolean existsByEmail(String email);
}

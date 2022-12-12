package bg.dimps.tusos.repositories;

import bg.dimps.tusos.entities.ERole;
import bg.dimps.tusos.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

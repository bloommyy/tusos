package bg.dimps.tusos.repositories;

import bg.dimps.tusos.entities.ElectricAppliances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricApplianceRepository extends JpaRepository<ElectricAppliances, Long> {
    ElectricAppliances findElectricAppliancesByApplianceID(Long electricApplianceId);
}

package bg.dimps.tusos.repositories;

import bg.dimps.tusos.entities.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    Furniture findFurnitureByFurnitureID(Long furnitureId);
}

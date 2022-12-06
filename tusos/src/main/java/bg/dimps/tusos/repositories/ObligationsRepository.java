package bg.dimps.tusos.repositories;

import bg.dimps.tusos.entities.MonetaryObligation;
import bg.dimps.tusos.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObligationsRepository extends JpaRepository<MonetaryObligation,Long> {

    List<MonetaryObligation> findObligationByStudent(Student student);

}


package bg.dimps.tusos.repositories;

import bg.dimps.tusos.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}

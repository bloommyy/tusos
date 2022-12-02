package bg.dimps.tusos.repositories;

import bg.dimps.tusos.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFacultyNumber(String facultyNumber);
}

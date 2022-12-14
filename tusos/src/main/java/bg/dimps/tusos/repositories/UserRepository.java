package bg.dimps.tusos.repositories;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    List<Student> findByFacultyNumber(String facultyNumber);

    Optional<User> findUserByEmail(String email);

    Boolean existsByEmail(String email);
}

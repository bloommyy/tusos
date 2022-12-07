package bg.dimps.tusos.security.services;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.repositories.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final StudentRepository userRepository;

    public UserDetailsServiceImpl(StudentRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String facultyNumber) throws UsernameNotFoundException {
        Student user = userRepository.findStudentByFacultyNumber(facultyNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + facultyNumber));

        return UserDetailsImpl.build(user);
    }
}

package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.UserRepository;
import bg.dimps.tusos.security.jwt.JwtUtils;
import bg.dimps.tusos.security.pojos.request.LoginRequest;
import bg.dimps.tusos.security.pojos.request.StudentSignupRequest;
import bg.dimps.tusos.security.pojos.response.JwtResponse;
import bg.dimps.tusos.security.services.UserDetailsImpl;
import bg.dimps.tusos.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {

    // TODO: Да преместя всички userRepository към userService

    private final UserRepository userRepository;
    private final StudentService studentService;

    public StudentController(UserRepository userRepository, StudentService studentService) {
        this.userRepository = userRepository;
        this.studentService = studentService;
    }

    @GetMapping("/fetch")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public List<User> getAllStudents(){
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody StudentSignupRequest request) {
        String checkRequest = studentService.checkRequest(request);
        if (checkRequest != "ok") {
            return ResponseEntity.badRequest().body("User already exists");
        } else {
            studentService.saveStudent(request);
        }
        return ResponseEntity.ok("User registered successfully!");
    }

    @DeleteMapping("/delete")
        public String deleteStudent(String facultyNumber){
            List<Student> result = userRepository.findByFacultyNumber(facultyNumber);

            if(result.isEmpty())
                return "Student not found";
            for(Student student:result){
                userRepository.delete(student);
            }
            return "Student with facultyNumber - " + facultyNumber + " was deleted";
        }


}

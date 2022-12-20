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

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    private final UserRepository userRepository;
    private final StudentService studentService;

    public StudentController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserRepository userRepository, StudentService studentService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
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

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getEmail(),
                roles));
    }

    @DeleteMapping("/delete")
    public String deleteStudent(String facultyNumber) {
        List<Student> result = userRepository.findByFacultyNumber(facultyNumber);

        if (result.isEmpty())
            return "Student not found";
        for (Student student : result) {
            userRepository.delete(student);
        }
        return "Student with facultyNumber - " + facultyNumber + " was deleted";
    }

    @GetMapping("/hasRoom")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public ResponseEntity<?> hasRoom()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String studentEmail = authentication.getName();
        Student student = studentService.getStudentByEmail(studentEmail);
        if (student == null )
            return ResponseEntity.badRequest().body("Не е намерен студент!");
        if (student.getRoom() == null)
            return ResponseEntity.ok(false);

        return ResponseEntity.ok(true);
    }
}

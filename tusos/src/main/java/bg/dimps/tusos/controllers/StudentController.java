package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.UserRepository;
import bg.dimps.tusos.security.jwt.JwtUtils;
import bg.dimps.tusos.security.pojos.request.LoginRequest;
import bg.dimps.tusos.security.pojos.request.SignupRequest;
import bg.dimps.tusos.security.pojos.response.JwtResponse;
import bg.dimps.tusos.security.services.UserDetailsImpl;
import bg.dimps.tusos.services.UserService;
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
    private final UserService userService;

    public StudentController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserRepository userRepository, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/fetch")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public List<User> getAllStudents(){
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@RequestBody SignupRequest request){
        String checkRequest = userService.checkRequest(request);
        if(checkRequest != "ok"){
            return ResponseEntity.badRequest().body("User already exists");
        }else{
            userService.saveUser(request);
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

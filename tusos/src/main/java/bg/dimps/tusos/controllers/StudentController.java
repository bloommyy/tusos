package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.UserRepository;
import bg.dimps.tusos.security.pojos.request.StudentSignupRequest;
import bg.dimps.tusos.services.StudentService;
import bg.dimps.tusos.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        studentService.validateStudent(request.getEmail(), request.getPassword(), request.getFirstName(), request.getMiddleName(), request.getLastName(), request.getPhoneNumber(), request.getFacultyNum(), request.getRepeatedPassword());
        String checkRequest = studentService.checkRequest(request);
        if (checkRequest != "ok") {
            return ResponseEntity.badRequest().body("User already exists");
        } else {
            studentService.saveStudent(request);
        }
        return ResponseEntity.ok("User registered successfully!");
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


}

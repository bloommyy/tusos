package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.UserRepository;
import bg.dimps.tusos.security.pojos.request.StudentSignupRequest;
import bg.dimps.tusos.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        try {
            studentService.validateRequest(request);
            studentService.checkExistenceByEmail(request.getEmail());
            studentService.saveStudent(request);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("Успешно се регистрирахте!");
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

    @PostMapping("/hasRoom")
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

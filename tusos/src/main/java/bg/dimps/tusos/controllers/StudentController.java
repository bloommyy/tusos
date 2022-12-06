package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.repositories.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepo;

    public StudentController(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping("/fetch")
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }

    @DeleteMapping("/delete")
        public String deleteStudent(String facultyNumber){
            List<Student> result = studentRepo.findByFacultyNumber(facultyNumber);

            if(result.isEmpty())
                return "Student not found";
            for(Student student:result){
                studentRepo.delete(student);
            }
            return "Student with facultyNumber - " + facultyNumber + " was deleted";
        }
}

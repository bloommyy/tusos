package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.MonetaryObligation;
import bg.dimps.tusos.entities.Room;
import bg.dimps.tusos.entities.Student;
import bg.dimps.tusos.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private final StudentRepository studentRepo;

    public StudentController(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PostMapping("/register")
    public List<Student> registerStudent(
            Room room,
            ArrayList<MonetaryObligation> obligations,
            String facultyNumber,
            String firstName,
            String middleName,
            String lastName,
            String phoneNumber,
            String email,
            String password){

        List<Student> students = studentRepo.findAll();
        List<Student> response = new ArrayList<>();

        if(students.isEmpty()){
            response.add(studentRepo.save(new Student(room,obligations,facultyNumber,firstName,middleName,lastName,phoneNumber,email,password)));
        }
        for(Student student : students){
            student.setRoom(room);
            student.setObligations(obligations);
            student.setFacultyNumber(facultyNumber);
            student.setFirstName(firstName);
            student.setMiddleName(middleName);
            student.setLastName(lastName);
            student.setPhoneNumber(phoneNumber);
            student.setEmail(email);
            student.setPassword(password);
            response.add(studentRepo.save(student));
        }
        return response;
    }

}

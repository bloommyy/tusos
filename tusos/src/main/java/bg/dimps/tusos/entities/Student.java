package bg.dimps.tusos.entities;

import bg.dimps.tusos.security.pojos.request.StudentSignupRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends User {
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "student")
    @JsonBackReference
    private List<MonetaryObligation> obligations;

    @Column(unique = true)
    private String facultyNumber;

    public Student(
            Long id,
            String firstName,
            String middleName,
            String lastName,
            String phoneNumber,
            String email,
            String password,
            Set<Role> roles,
            Room room,
            List<MonetaryObligation> obligations,
            String facultyNumber) {
        super(id, firstName, middleName, lastName, phoneNumber, email, password, roles);
        this.room = room;
        this.obligations = obligations;
        this.facultyNumber = facultyNumber;
    }

    public Student (StudentSignupRequest studentSignupRequest, String password) {
        super(studentSignupRequest, password);
        this.facultyNumber = studentSignupRequest.getFacultyNum();
        this.room = null;
        this.obligations = new ArrayList<>();
    }

    public Student() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<MonetaryObligation> getObligations() {
        return obligations;
    }

    public void setObligations(List<MonetaryObligation> obligations) {
        this.obligations = obligations;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}

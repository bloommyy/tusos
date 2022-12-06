package bg.dimps.tusos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "student")
    @JsonBackReference
    private List<MonetaryObligation> obligations;
    private String facultyNumber;

    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student(Room room, ArrayList<MonetaryObligation> obligations, String facultyNumber, String firstName, String middleName, String lastName, String phoneNumber, String email, String password) {
        this.room = room;
        this.obligations = obligations;
        this.facultyNumber = facultyNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
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

    public void setObligations(ArrayList<MonetaryObligation> obligations) {
        this.obligations = obligations;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public void MoveToRoom(Room room){

    }
    public void PayObligation(MonetaryObligation monObligation){

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

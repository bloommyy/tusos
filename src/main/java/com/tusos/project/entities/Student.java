package com.tusos.project.entities;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person {

    @ManyToOne
    @JoinColumn(name = "room_room_id")
    private Room room;
    private List<MonetaryObligation> obligations;
    private String facultyNomer;

    public Student(Room room, List<MonetaryObligation> obligations, String facultyNomer) {
        this.room = room;
        this.obligations = obligations;
        this.facultyNomer = facultyNomer;
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

    public String getFacultyNomer() {
        return facultyNomer;
    }

    public void setFacultyNomer(String facultyNomer) {
        this.facultyNomer = facultyNomer;
    }

    public void MoveToRoom(Room room){

    }
    public void PayObligation(MonetaryObligation monObligation){

    }
}

package bg.dimps.tusos.entities;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;

@Entity
@Table(name = "host")
public class Host extends Person {
    public void MoveStudentToRoom(Student student, Room room){

    }
    public void RemoveStudent(Student student){

    }
    public void AddMonetaryObligation( MonetaryObligation monObligation){

    }
}

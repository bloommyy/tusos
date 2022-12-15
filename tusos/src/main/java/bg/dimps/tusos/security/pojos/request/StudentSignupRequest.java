package bg.dimps.tusos.security.pojos.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentSignupRequest extends UserSignupRequest {
    @NotBlank
    @Size(min = 10, max = 10)
    private String facultyNum;

    public String getFacultyNum() {
        return facultyNum;
    }

    public void setFacultyNum(String facultyNum) {
        this.facultyNum = facultyNum;
    }
}

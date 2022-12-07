package bg.dimps.tusos.security.pojos.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String facultyNumber;

    @NotBlank
    private String password;

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package bg.dimps.tusos.security.pojos.request;

import javax.validation.constraints.NotBlank;

public class HostSignupRequest extends UserSignupRequest {
    @NotBlank
    private String dormID;

    public String getDormID() {
        return dormID;
    }

    public void setDormID(String dormID) {
        this.dormID = dormID;
    }
}
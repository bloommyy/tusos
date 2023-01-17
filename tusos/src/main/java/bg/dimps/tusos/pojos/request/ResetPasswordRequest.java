package bg.dimps.tusos.pojos.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ResetPasswordRequest {
    @NotBlank
    private String email;
}

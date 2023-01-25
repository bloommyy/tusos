package bg.dimps.tusos.pojos.request;

import lombok.Data;

@Data
public class EmailSendRequest {
    private String receiverEmail;
    private String subject;
    private String content;
}

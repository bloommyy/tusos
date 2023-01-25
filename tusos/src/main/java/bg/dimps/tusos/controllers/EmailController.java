package bg.dimps.tusos.controllers;

import bg.dimps.tusos.pojos.request.EmailSendRequest;
import bg.dimps.tusos.services.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("email")
public class EmailController {
    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService){
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailSendRequest emailSendRequest){
        this.emailSenderService.sendEmail(
                emailSendRequest.getReceiverEmail(), emailSendRequest.getSubject(), emailSendRequest.getContent());
        return ResponseEntity.ok("OK");
    }
}

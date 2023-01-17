package bg.dimps.tusos.services;

import bg.dimps.tusos.config.AppConfig;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdentityServiceImpl implements IdentityService{
    private static final String RESET_RESENT_PASSWORD_MESSAGE = "New password was generated for your account: %s";
    private static final String RESET_SUCCESSFUL_SENT =
            "Reset message was successfuly sent to the typed address if such user exists.";
    private static final String RESET_MESSAGE_SUBJECT = "New password generation request";

    private final EmailSenderService emailSenderService;
    private final UserRepository userRepository;

    public IdentityServiceImpl(EmailSenderService emailSenderService, UserRepository userRepository){
        this.emailSenderService = emailSenderService;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> resetPassword(String receiverEmail) {
        Optional<User> user = userRepository.findUserByEmail(receiverEmail);

        if(!user.isEmpty()) {
            String newPassword = java.util.UUID.randomUUID().toString();
            String message = String.format(RESET_RESENT_PASSWORD_MESSAGE, newPassword);

            this.emailSenderService.sendEmail(receiverEmail, RESET_MESSAGE_SUBJECT, message);
            user.get().setPassword(newPassword);
            userRepository.save(user.get());

            // TODO mailsend and password change in transaction
        }


        return ResponseEntity.ok(RESET_SUCCESSFUL_SENT);
    }
}

package bg.dimps.tusos.services;

import bg.dimps.tusos.config.AppConfig;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class IdentityServiceImpl implements IdentityService{
    private static final String RESET_RESENT_PASSWORD_MESSAGE = "New password was generated for your account: %s";
    private static final String RESET_SUCCESSFUL_SENT =
            "Reset message was successfuly sent to the typed address if such user exists.";
    private static final String RESET_MESSAGE_SUBJECT = "New password generation request";

    private final EmailSenderService emailSenderService;
    private final UserRepository userRepository;

    private final DataSource dataSource;

    private final PasswordEncoder passwordEncoder;

    public IdentityServiceImpl(
            EmailSenderService emailSenderService,
            UserRepository userRepository,
            DataSource dataSource,
            PasswordEncoder passwordEncoder){
        this.emailSenderService = emailSenderService;
        this.userRepository = userRepository;
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<String> resetPassword(String receiverEmail) {
        Optional<User> user = userRepository.findUserByEmail(receiverEmail);

        try{
            if(!user.isEmpty()) {
                try (Connection connection = dataSource.getConnection()) {

                    connection.setAutoCommit(false);

                    try{
                        String newPassword = java.util.UUID.randomUUID().toString();
                        String message = String.format(RESET_RESENT_PASSWORD_MESSAGE, newPassword);

                        this.emailSenderService.sendEmail(receiverEmail, RESET_MESSAGE_SUBJECT, message);
                        user.get().setPassword(passwordEncoder.encode(newPassword));
                        userRepository.save(user.get());

                        connection.commit();
                    }
                    catch (Exception ex){
                        connection.rollback();
                    }
                    finally {
                        connection.setAutoCommit(true);
                    }
                }
            }
        }catch(SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(RESET_SUCCESSFUL_SENT);
    }
}

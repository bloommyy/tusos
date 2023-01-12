package bg.dimps.tusos.services;

import bg.dimps.tusos.config.AppConfig;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{
    private final JavaMailSender mailSender;
    private final AppConfig appConfig;

    public EmailSenderServiceImpl(JavaMailSender mailSender, AppConfig appConfig) {
        this.mailSender = mailSender;
        this.appConfig = appConfig;
    }

    @Override
    public void sendEmail(String receiver, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        AppConfig.EmailSenderConfig emailSenderConfig = appConfig.getEmailConfig();

        simpleMailMessage.setFrom(emailSenderConfig.getSentFrom());
        simpleMailMessage.setTo(receiver);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        this.mailSender.send(simpleMailMessage);
    }
}

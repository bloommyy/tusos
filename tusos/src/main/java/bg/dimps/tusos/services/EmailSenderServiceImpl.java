package bg.dimps.tusos.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{
    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String receiver, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //todo use config bean
        simpleMailMessage.setFrom("");
        simpleMailMessage.setTo("");
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        this.mailSender.send(simpleMailMessage);
    }
}

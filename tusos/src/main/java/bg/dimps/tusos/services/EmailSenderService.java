package bg.dimps.tusos.services;

public interface EmailSenderService {
    void sendEmail(String receiver, String subject, String content);
}

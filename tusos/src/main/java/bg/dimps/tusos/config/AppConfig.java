package bg.dimps.tusos.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "config")
@Validated
public class AppConfig {
    private final EmailSenderConfig emailConfig = new EmailSenderConfig();

    public EmailSenderConfig getEmailConfig() { return emailConfig; };

    @ConfigurationProperties(prefix = "spring.mail")
    @Data
    public class EmailSenderConfig {
        private String host;
        private String port;
        private String username;
        private String password;
        private String sentFrom;
    }
}
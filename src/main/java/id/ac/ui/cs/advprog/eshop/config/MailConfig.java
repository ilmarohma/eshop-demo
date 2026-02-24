package id.ac.ui.cs.advprog.eshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import jakarta.mail.internet.MimeMessage;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        return new JavaMailSender() {
            @Override
            public void send(MimeMessage mimeMessage) {
                logMail(mimeMessage);
            }

            @Override
            public void send(MimeMessage... mimeMessages) {
                for (MimeMessage msg : mimeMessages) {
                    logMail(msg);
                }
            }

            @Override
            public void send(MimeMessagePreparator... preparators) {
                // Not needed for this use case
            }

            @Override
            public void send(SimpleMailMessage simpleMessage) {
                System.out.println("=== Mock Email Sent ===");
                System.out.println("To: " + String.join(", ", simpleMessage.getTo()));
                System.out.println("Subject: " + simpleMessage.getSubject());
                System.out.println("Text: " + simpleMessage.getText());
                System.out.println("=======================");
            }

            @Override
            public void send(SimpleMailMessage... simpleMessages) {
                for (SimpleMailMessage msg : simpleMessages) {
                    send(msg);
                }
            }

            private void logMail(MimeMessage mimeMessage) {
                System.out.println("=== Mock Email Sent ===");
                System.out.println("MimeMessage logged (not sent to actual server)");
                System.out.println("=======================");
            }

            @Override
            public MimeMessage createMimeMessage() {
                // This won't be used since we're sending SimpleMailMessage
                return null;
            }

            @Override
            public MimeMessage createMimeMessage(java.io.InputStream inputStream) {
                // This won't be used since we're sending SimpleMailMessage
                return null;
            }
        };
    }
}

package com.site.siteweb.service;
    import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service; 

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendNewMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("farajampenda43@gmail.com");
        message.setTo("swediroben@gmail.com");
        message.setSubject("subject");
        message.setText("message ");
        mailSender.send(message);
        System.out.println("message envoyer");
    }
}
 

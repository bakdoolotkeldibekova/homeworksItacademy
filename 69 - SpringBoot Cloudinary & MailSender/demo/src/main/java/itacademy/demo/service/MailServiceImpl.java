package itacademy.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment environment;

    @Override
    public Boolean send(String toEmail, String subject, String text) {
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(text);
            simpleMailMessage.setTo(toEmail);
            simpleMailMessage.setFrom(environment.getProperty("spring.mail.username"));
            javaMailSender.send(simpleMailMessage);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
}

package itacademy.demo.controller;

import itacademy.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping
    public Boolean send(@RequestParam(name = "toEmail") String toEmail,
                        @RequestParam(name = "subject") String subject,
                        @RequestParam(name = "text") String text){
        return mailService.send(toEmail, subject, text);
    }
}

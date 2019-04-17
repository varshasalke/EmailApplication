package com.example.EmailApplication.Controller;

import com.example.EmailApplication.Model.Emails;
import com.example.EmailApplication.Model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api")
public class EmailController {
    @Autowired
    private SimpleMailMessage simpleMailMessage;
    @Autowired
    private MailSender mailSender;


    @Autowired
    private Logger logger;
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public Callable<ResponseEntity<Map<String, Object>>> searchForFirstPageProject(@RequestBody Emails emails) {
        return () -> {
            simpleMailMessage.setTo(emails.getTo());
            simpleMailMessage.setText(emails.getBody());
            simpleMailMessage.setSubject(emails.getSubject());
            mailSender.send(simpleMailMessage);
            logger.info("message send successfully");
            ResponseEntity<Map<String, Object>> resEntity;
            resEntity = new ResponseEntity("succss", HttpStatus.OK);
            return resEntity ;
        };
    }
}

package com.example.EmailApplication.Controller;

import com.example.EmailApplication.Model.Emails;
import com.example.EmailApplication.Model.Registration;
import com.example.EmailApplication.repos.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RegistrationController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RegistrationRepo registrationRepo;

    @Autowired
    private EmailController emailController;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody Registration registration){
        registrationRepo.save(registration);
        return ResponseEntity.ok(registration);
    }
}

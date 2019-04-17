package com.example.EmailApplication.repos;

import com.example.EmailApplication.Model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistrationRepo extends MongoRepository<Registration,String> {
}

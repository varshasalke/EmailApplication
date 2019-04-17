package com.example.EmailApplication.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class UtilConfig {
    @Bean
    public Logger getLogger(){
        return  Logger.getLogger(getClass().getName());
    }
}

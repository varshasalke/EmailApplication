package com.example.EmailApplication.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Data
public class Registration {

    @Id
    private String id;
    private String uName;
    private String password;
    private String confirmPassword;


}

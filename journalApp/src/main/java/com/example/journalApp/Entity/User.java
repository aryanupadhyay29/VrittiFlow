package com.example.journalApp.Entity;


import lombok.Data;
import org.springframework.stereotype.Indexed;


@Data
public class User {

    private Long id;

    private String userName;

    private String password;
}

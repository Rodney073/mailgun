package com.example.mailgun;

import com.example.mailgun.Mailgun.MailGun;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailgunApplication {

    public static void main(String[] args) throws UnirestException {
        SpringApplication.run(MailgunApplication.class, args);
    }

}

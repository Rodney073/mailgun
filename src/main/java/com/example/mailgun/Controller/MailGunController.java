package com.example.mailgun.Controller;

import com.example.mailgun.Mailgun.MailGun;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailGunController {

    private final MailGun mailGun;

    @Autowired
    public MailGunController(MailGun mailGun) {
        this.mailGun = mailGun;
    }

    @PostMapping("/mailgun/email")
    public @ResponseBody
    ResponseEntity<?> mailGunEmail(@RequestBody EmailValidationDTO emailValidationDTO) throws UnirestException {

        return ResponseEntity.status(HttpStatus.OK).body(mailGun.sendSimpleMessage(emailValidationDTO).toString());

    }

    @GetMapping("/mailgun/validation")
    public @ResponseBody
    ResponseEntity<?> mailGunSingleValidation(@RequestBody EmailValidationDTO emailDTO) throws UnirestException {

        return ResponseEntity.status(HttpStatus.OK).body(mailGun.validateEmail(emailDTO.getEmail()).toString());

    }

}

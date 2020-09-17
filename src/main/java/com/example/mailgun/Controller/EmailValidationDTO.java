package com.example.mailgun.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class EmailValidationDTO {
    private String username;
    private String kingdomName;
    private String email;
}

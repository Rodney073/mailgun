package com.example.mailgun.Mailgun;

import com.example.mailgun.Controller.EmailValidationDTO;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MailGun {

    private final ApiKeyConfiguration apiKeyConfiguration;

    @Autowired
    public MailGun(ApiKeyConfiguration apiKeyConfiguration) {
        this.apiKeyConfiguration = apiKeyConfiguration;
    }

    public JsonNode sendSimpleMessage(EmailValidationDTO emailValidationDTO) throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + apiKeyConfiguration.getDomain() + "/messages")
                .basicAuth("api", apiKeyConfiguration.getKey())
                .queryString("from", "Tribes Team <USER@YOURDOMAIN.COM>")
                .queryString("to", emailValidationDTO.getEmail())
                .queryString("subject", emailValidationDTO.getUsername() + ", your kingdom is ready!")
                .queryString("html", returnEmail(emailValidationDTO))
                .asJson();
        return request.getBody();
    }

    public String returnEmail(EmailValidationDTO emailValidationDTO) {

        String token = "asdf";

        return "<html>" +
                "<h2>Welcome " + emailValidationDTO.getUsername() + "!</h2>" +
                "<p>Your " + emailValidationDTO.getKingdomName() +
                " is ready! You just need to confirm your email address and then you are ready to conquer the world. <br>" +
                "Please confirm your email address by clicking this button: </p><button type=\"button\">" +
                "<a href=\"http://localhost:8080/verification/" + token + "\">Click Me!</a></button>" +
                "<p>— The Tribes Team</p>" +
                "</html> ";
    }


    public JsonNode validateEmail(String email) throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.get("https://api.mailgun.net/v4/address/validate")
                .basicAuth("api", apiKeyConfiguration.getKey())
                .queryString("address", email)
                .asJson();

        return request.getBody();
    }
}

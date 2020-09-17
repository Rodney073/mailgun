package com.example.mailgun.Mailgun;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@NoArgsConstructor
@Setter
@Getter
@ConfigurationProperties(prefix = "application.apikey")
public class ApiKeyConfiguration {

    private String key;
    private String domain;

}
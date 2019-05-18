package com.study;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix="person")
@Data
public class CustomerPropertites {
    private String id;
    private String name;
    private String gender;
    private String address;
}

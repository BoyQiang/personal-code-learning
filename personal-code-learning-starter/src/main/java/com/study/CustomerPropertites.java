package com.study;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="person")
@Data
public class CustomerPropertites {
    private String id;
    private String name;
    private String gender;
    private String address;
}

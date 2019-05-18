package com.study;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CustomerPropertites.class)
@ConditionalOnProperty(prefix="person", name="enabled", havingValue = "true")
@Data
public class CustomerConfiguration {

    @Autowired
    private CustomerPropertites customerPropertites;

    @Bean
    @ConditionalOnClass(CustomerService.class)
    @ConditionalOnMissingBean(CustomerService.class)
    public CustomerService customerService(){
        return CustomerService.builder()
                .id(customerPropertites.getId())
                .name(customerPropertites.getName())
                .gender(customerPropertites.getGender())
                .address(customerPropertites.getAddress())
                .build();
    }
}

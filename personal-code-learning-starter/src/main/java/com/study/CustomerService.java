package com.study;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerService {

    private String id;
    private String name;
    private String gender;
    private String address;

    public String getInfo(){
        return id + "-" + name + "-" + gender + "-" + address;
    }

}

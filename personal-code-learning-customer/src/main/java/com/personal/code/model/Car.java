package com.personal.code.model;

import java.util.Optional;

import lombok.Setter;

@Setter
public class Car {

    private Insurance insurance;

    public Insurance getInsurance(){
        return insurance;
    }
//    private Optional<Insurance> insurance;
//
//    public Optional<Insurance> getInsurance() {
//        return insurance;
//    }
}

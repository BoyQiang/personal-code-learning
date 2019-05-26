package com.personal.code.model;

import java.util.Optional;

import lombok.Setter;

@Setter
public class Person {

    private Car car;

    public Car getCar(){
        return car;
    }
//    private Optional<Car> car;
//
//    public Optional<Car> getCar() {
//        return car;
//    }
}

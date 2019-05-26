package com.personal.code.biz;

import java.util.Objects;
import java.util.Optional;

import com.personal.code.model.Car;
import com.personal.code.model.Insurance;
import com.personal.code.model.Person;

public class CarBizIml {

    /**
     *
     * 问题是
     * 1：person对象中可能并没有car对象 这个人没有车
     * 2：car对象中可能并没有insurance对象 这辆车并没有买保险
     * 直接取会出现NPE问题
     */
    public String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    /**
     * 避免NullPointerException的第一次尝试
     * 防御式检查减少NullPointerException
     * 缺点：if嵌套太多 代码可读性差 不方便扩展
     */
    public String getCarInsuranceNameWithDefensiveInspection(Person person) {
        if (Objects.nonNull(person)) {
            Car car = person.getCar();
            if (Objects.nonNull(car)) {
                Insurance insurance = car.getInsurance();
                if (Objects.nonNull(insurance)) {
                    return insurance.getName();
                }
            }
        }
        return "Unkown";
    }

    /**
     * 避免NullPointerException的第二次尝试
     * return式检查减少NullPointerException
     * 缺点：方法有了四个 截然不同的退出点，流程是极易出错
     */
    public String getCarInsuranceNameWithReturnInspection(Person person) {
        if (Objects.isNull(person)) {
            return "Unkown";
        }
        Car car = person.getCar();
        if (Objects.isNull(car)) {
            return "Unkown";
        }
        Insurance insurance = car.getInsurance();
        if (Objects.isNull(insurance)) {
            return "Unkown";
        }
        return insurance.getName();
    }

//    public String getCarInsuranceNameWithOptional(Person person) {
//        return Optional.ofNullable(person)
//                .flatMap(Person::getCar)
//                .flatMap(Car::getInsurance)
//                .map(Insurance::getName)
//                .orElse("Unkown");
//    }

}

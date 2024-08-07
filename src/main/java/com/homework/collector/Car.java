package com.homework.collector;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Car {

    static Car car;

    private String model;

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Finalize %s%n", car);
        car = this;
    }

    public Car(String model) {
        this.model = model;
        System.out.printf("Created new Car %s%n", model);
    }
}

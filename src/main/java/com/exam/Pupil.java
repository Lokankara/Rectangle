package com.ua.lab.exam;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Pupil {
    private String name;
    private int grade;
    private boolean isBoy;
    private double mark;
}

package com.classwork.collection.generic;

public class ChidlCircleInterfaceImpl implements CircleInterface {
    private String color;

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

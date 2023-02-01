package com.homework.shape;

public class ChidlCircleInterfaceImpl implements CircleInterface {
    private String color;

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
}
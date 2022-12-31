package com.homework;

import java.awt.*;

public class Bottle {
    private Integer id;
    private Double volume;
    private Double measure;
    private String material;
    private String liquid;
    private Color color;
    private boolean full;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getMeasure() {
        return measure;
    }

    public void setMeasure(Double measure) {
        this.measure = measure;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getLiquid() {
        return liquid;
    }

    public void setLiquid(String liquid) {
        this.liquid = liquid;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "id=" + id +
                ", volume=" + volume +
                ", measure=" + measure +
                ", material='" + material + '\'' +
                ", liquid='" + liquid + '\'' +
                ", color=" + color +
                ", full=" + full +
                '}';
    }
}

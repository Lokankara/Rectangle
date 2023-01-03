package com.homework.io;

public class Bottle {
    private Integer id;
    private Double volume;
    private String material;
    private String drink;
    private boolean full;
	//order 1: 0,5; 2: 0.51-0.99; 3: 1.0
	private int capacity;
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(double volume) {
		this.capacity = volume < 0.5 ? 1 : volume >= 0.5 && volume < 1 ? 2 : 3;
	}

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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getLiquid() {
        return drink;
    }

    public void setLiquid(String liquid) {
        this.drink = liquid;
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
                ", measure=" + capacity +
                ", material='" + material + '\'' +
                ", liquid='" + drink + '\'' +
                ", full=" + full +
                '}';
    }
}

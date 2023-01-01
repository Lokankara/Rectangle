package main.java.com.ua.lab.homework;

public class Bottle {
	private Integer id;
	private Double volume;
	private Double measure;
	private String material;
	private String drink;
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
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Bottle{");
		stringBuilder.append("id=");
		stringBuilder.append(id);
		stringBuilder.append(", volume=");
		stringBuilder.append(volume);
		stringBuilder.append(", measure=");
		stringBuilder.append(measure);
		stringBuilder.append(", material='");
		stringBuilder.append(material);
		stringBuilder.append('\'');
		stringBuilder.append(", liquid='");
		stringBuilder.append(drink);
		stringBuilder.append('\'');
		stringBuilder.append(", full=");
		stringBuilder.append(full);
		stringBuilder.append('}');
		return stringBuilder.toString();
	}
}

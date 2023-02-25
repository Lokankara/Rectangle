package  main.java.com.ua.lab;

import java.util.Objects;

public class Pupil {
	private String name;
	private int grade;
	private boolean isBoy;
	private double mark;
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isBoy() {
		return isBoy;
	}
	public void setBoy(boolean isBoy) {
		this.isBoy = isBoy;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Pupil [name=" + name + ", grade=" + grade + ", isBoy=" + isBoy + ", mark=" + mark + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(grade, isBoy, mark, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pupil other = (Pupil) obj;
		return grade == other.grade && isBoy == other.isBoy
				&& Double.doubleToLongBits(mark) == Double.doubleToLongBits(other.mark)
				&& Objects.equals(name, other.name);
	}
}
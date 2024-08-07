package com.exam;

import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pupil {
	private String name;
	private int grade;
	private boolean isBoy;
	private double mark;

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
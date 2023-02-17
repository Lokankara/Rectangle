package com.homework.threads.airport;

import java.util.Comparator;
import java.util.Objects;

class Family implements Comparator<Family> {
	private Integer count;
	private String name;
	private Integer planeId;
	private String travelTo;
	private Integer busId;

	public Family(Integer count, String name, Integer planeId, String travelTo) {
		super();
		this.name = name;
		this.count = count;
		this.planeId = planeId;
		this.travelTo = travelTo;
	}

	public Integer getPlaneId() {
		return planeId;
	}

	public Integer getCount() {
		return count;
	}

	public String getTravelTo() {
		return travelTo;
	}
	
	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	@Override
	public String toString() {
		return String.format("%s member(s) from the %s family are traveling to %s by plane#%s", count, name,
				travelTo, planeId);
	}

	@Override
	public int compare(Family a, Family b) {
		return Integer.compare(b.getCount(), a.getCount());
	}

	@Override
	public int hashCode() {
		return Objects.hash(busId, count, name, planeId, travelTo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Family other = (Family) obj;
		return Objects.equals(busId, other.busId) && Objects.equals(count, other.count)
				&& Objects.equals(name, other.name) && Objects.equals(planeId, other.planeId)
				&& Objects.equals(travelTo, other.travelTo);
	}
}
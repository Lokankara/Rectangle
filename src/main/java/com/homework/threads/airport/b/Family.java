//package com.homework.threads.airport.b;
//
//import java.util.Comparator;
//
//class Family implements Comparator<Family> {
//	private Integer count;
//	private String name;
//	private Integer planeId;
//	private String travelTo;
//	private Integer busId;
//
//	public Family(Integer count, String name, Integer planeId, String travelTo) {
//		super();
//		this.name = name;
//		this.count = count;
//		this.planeId = planeId;
//		this.travelTo = travelTo;
//	}
//
//	public Integer getPlaneId() {
//		return planeId;
//	}
//
//	public Integer getCount() {
//		return count;
//	}
//
//	public String getTravelTo() {
//		return travelTo;
//	}
//	
//	public Integer getBusId() {
//		return busId;
//	}
//
//	public void setBusId(Integer busId) {
//		this.busId = busId;
//	}
//
//	@Override
//	public String toString() {
//		return String.format("%s passenger(s) from the %s family are traveling to %s by plane#%s", count, name,
//				travelTo, planeId);
//	}
//
//	@Override
//	public int compare(Family a, Family b) {
//		return Integer.compare(a.getCount(), b.getCount());
//	}
//}
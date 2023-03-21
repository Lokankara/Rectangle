package com.exam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;

public interface Quiz {
	public static int COUNTER = 0;
	static TreeMap<Object, Object> tm = new TreeMap<>();
	static Map<Object, ? super ArrayList> lhm = new LinkedHashMap<Object, ArrayList>();
	static Map<Object, ?> lhms = new LinkedHashMap<Object, Object>();
	static Map<Object, Object> m = new TreeMap<Object, Object>();

	public static void main(String[] args) {
//		m.put("1", new ArrayList<>());
//		m.put(1, new Object());
//		m.put(1, new ArrayList<>());
//		m.put(1.05, "new ArrayList()");
//		System.out.println(m);
//		CountDownLatch cdl = new CountDownLatch(10);
//
//		Counter counter = new Counter(cdl);
//
//		try {
//			cdl.await();
//		} catch (InterruptedException e) {
//			System.out.println(e);
//		}
//		System.out.println(COUNTER);
	
	int num = 9;
	boolean div = false;
	while(!div){
	System.out.print(num);
	if(num%7 == 0){
	div = true;}
	--num;}}
}

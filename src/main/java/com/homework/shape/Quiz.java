package com.ua.lab.homework.shape;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public interface Quiz {
    static  int COUNTER = 0;
    //    static Map m = new TreeMap<>();
//    static Map<Object, ? super ArrayList> m = new LinkedHashMap<Object, ArrayList>();
//    static Map<Object, ?> m = new LinkedHashMap<Object, Object>();
    static Map<Object, Object> m = new TreeMap<Object, Object>();

    public static void main(String[] args) {
    m.put("1", new ArrayList<>());
    m.put(1, new Object());
    m.put(1, new ArrayList<>());
    m.put(1.05, "new ArrayList()");
        System.out.println(m);
//        CountDownLatch cdl = new CountDownLatch(10);
//
//        Counter counter = new Counter(cdl);
//
//        try {
//            cdl.await();
//        } catch (InterruptedException e) {
//            System.out.println(e);
//        }
//        System.out.println(COUNTER);

    }
}

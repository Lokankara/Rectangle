package com.exam;

import java.util.Arrays;
import java.util.List;

public class Quiz5 {
    public static void main(String[] args) {
        List<Clazz> objectList = Arrays.asList(
                new Clazz(1,"A"),
                new Clazz(1,"B"),
                new Clazz(1,"C"),
                new Clazz(1,"D")
        );

//        Object result = objectList.stream().collect(
//                Collectors.teeing(
//                        Collectors.filtering(o-> o.getId() > 2, Collectors.toList()),
//                        Collectors.filtering(o-> o.getId() > 2, Collectors.counting()),
//                        (list, count) -> {
//                            Map<String, Object> map = new HashMap<>();
//                            map.put("objects", list);
//                            map.put("count", count);
//                            return map;
//                        }
//                ));
        System.out.println(objectList);
//        System.out.println(result);
    }
}

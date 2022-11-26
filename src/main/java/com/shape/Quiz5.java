package com.shape;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz5 {
    public static void main(String[] args) {
        var objectList = Arrays.asList(
                new Clazz(1,"A"),
                new Clazz(1,"B"),
                new Clazz(1,"C"),
                new Clazz(1,"D")
        );

//        var result  = objectList.stream().collect(
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
//        System.out.println(result);
    }
}

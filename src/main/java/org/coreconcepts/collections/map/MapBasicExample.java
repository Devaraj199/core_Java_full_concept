package org.coreconcepts.collections.map;

import java.util.*;

public class MapBasicExample {
    public static void main(String[] args) {
//        basicMapExercise();
        iteratorOverMap();
    }

    private static void iteratorOverMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Deva",20);
        map.put("Kumar",40);
        map.put("Satish",60);
        map.put("Prakash",20);
        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // 1. Using entrySet with for-each loop
        System.out.println("Using entrySet:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // 2. Using keySet and get
        System.out.println("\nUsing keySet:");
        for (String country : map.keySet()) {
            System.out.println(country + " - " + map.get(country));
        }

        // 3. Using values (when you only need values)
        System.out.println("\nJust values:");
        for (Integer name : map.values()) {
            System.out.println(name);
        }

        // 4. Using forEach with lambda (Java 8+)
        System.out.println("\nUsing forEach with lambda:");
        map.forEach((country, capital) ->
                System.out.println(country + " - " + capital));
    }

    private static void basicMapExercise() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Deva",20);
        map.put("Kumar",40);
        map.put("Satish",60);
        map.put("Prakash",20);
        Set<String> nameList = map.keySet();
        List<Integer> valueList = map.values().stream().toList();
        map.put("Mahesh",29);
        map.putIfAbsent("Vasu",100);
        map.replace("Mahesh",89);
        map.compute("Satish",(k,v)->v+ 5);
        map.computeIfPresent("Vasu", (key, value) -> value * 2);
        map.computeIfAbsent("Mango", key -> 15);
        map.forEach((k,v)->{
            System.out.print(k+" "+ v+",");
        });
        Integer value =  map.get("prakash");
        Integer value1 = map.getOrDefault("Prakash",80);
//        System.out.println(value1);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries){
//            System.out.println(entry.getKey());
        }
//
//        System.out.println(map.containsKey("Prakash")); // true
//        System.out.println(map.containsKey("Prakah")); // false
//        System.out.println(map.containsValue(20)); // true
//        System.out.println(map.containsValue(63)); // false
//        System.out.println(map.size());

    }
}

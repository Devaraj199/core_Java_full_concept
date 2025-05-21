package org.coreconcepts.collections.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapExercises {
    public static void main(String[] args) {
        // Merge two maps ;
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        map1.put("Pine Apple",100);
        map1.put("Dragon Fruits",300);
        map1.put("Apple",80);
        map1.put("Mango",320);
        map2.put("Potato",40);
        map2.put("Tomato",150);
        map2.put("Onion",10);
        map2.put("Ginger",120);
        map1.putAll(map2);
        Map<String, Integer> collect =  Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(a,b)->a));
        Map<String, Integer> anotherMergedMap = new HashMap<>(map1);
        map2.forEach((a,b)->anotherMergedMap.merge(a,b,(k,v)->k));
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        map2.forEach((key, value) -> mergedMap.put(key, value));
        System.out.println(mergedMap);
    }


}

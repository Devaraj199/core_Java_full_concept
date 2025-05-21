package org.coreconcepts.collections.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class UnModifiedMapExample {
    public static void main(String[] args) {
        Map<String, Integer> mutableMap = new HashMap<>();
        mutableMap.put("One", 1);
        mutableMap.put("Two", 2);
        mutableMap.put("Three", 3);
        Map<String,Integer> unModifiedMap = Collections.unmodifiableMap(mutableMap);
        Map<String,Integer> mapOf = Map.of("Deva",37,"Mohan",90);
//        unModifiedMap.put("Five",5);// UnsupportedOperationException
        System.out.println(unModifiedMap);
//        mapOf.put("Kiran",77);// UnsupportedOperationException
        System.out.println(mapOf);
        Map<String, Integer> immutableMap = Map.ofEntries(
                entry("One", 1),
                entry("Two", 2),
                entry("Three", 3),
                entry("Four", 4)
        );
        Map<String, Integer> immutableCopy = Map.copyOf(mutableMap);
        immutableCopy.put("Eight",8); // UnsupportedOperationException
        immutableMap.put("Eight",8); // UnsupportedOperationException
    }
}

package org.coreconcepts.collections.map;

import java.util.*;

public class SortingMap {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("John", 25);
        unsortedMap.put("Alice", 22);
        unsortedMap.put("Bob", 30);
        unsortedMap.put("Zack", 28);
        Map<String,Integer> sortedMap = new TreeMap<>(unsortedMap); // Natural Order
        Map<String,Integer> reverseKeyMap = new TreeMap<>(Collections.reverseOrder());
        reverseKeyMap.putAll(unsortedMap);
        System.out.println(reverseKeyMap);
    }
}

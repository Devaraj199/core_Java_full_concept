package org.coreconcepts.collections.map;

import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<String,Integer> person = new Hashtable<>();
        person.put("Suresh",25);
        person.put("Mohan",35);
        person.put("Kumar",65);
        person.put("Dilip",78);
        System.out.println(person);
        for(String s: person.keySet()){
            System.out.println(s);
        }
        for(Integer n: person.values()){
            System.out.println(n);
        }
        for(Map.Entry<String,Integer> entry: person.entrySet()){
            System.out.println(entry);
        }
        System.out.println(person.get("Dilip"));
        System.out.println(person.isEmpty());
    }
}

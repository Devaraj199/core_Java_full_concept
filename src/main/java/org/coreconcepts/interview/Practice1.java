package org.coreconcepts.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice1 {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("Java is fun", "Streams are powerful","is fun");
        Map<String, Integer> collect = sentences.stream().
                flatMap(word -> Arrays.stream(word.split(" "))
                        .map(String::toUpperCase))
                .collect(Collectors.toMap(Function.identity(),String::length,(a,b)->a));

        Map<String, Long> collect1 = sentences.stream().
                flatMap(word -> Arrays.stream(word.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);
        
        int x = 3773;
        String string = Integer.toString(x);
    }
}

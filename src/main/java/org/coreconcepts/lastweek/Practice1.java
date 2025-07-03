package org.coreconcepts.lastweek;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {
        int[] values = {12,3,44,67,43};
        int[] values1 = {23,4,66,7};
        String str1 = "madam";
        List<List<Integer>> list = Arrays.asList(Arrays.asList(2, 4, 43, 56), Arrays.asList(12, 13, 14));
        List<List<String>> stringList = Arrays.asList(List.of("Hello", "Kumar","Kumar", "Pradhan"), List.of("Madam"));
        List<Integer> greaterThan30 = list.stream().flatMap(List::stream).filter(v->v<30).toList();
        Map<String, Long> collect2 = stringList.stream().flatMap(List::stream).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Integer> collect3 = stringList.stream().flatMap(List::stream).collect(Collectors.toMap(Function.identity(), String::length, (a, b) -> a));
        System.out.println(collect3);
        int[] array = Arrays.stream(values).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int secondHighest = Arrays.stream(values).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        int[] sortedArray = Stream.concat(Arrays.stream(values).boxed(), Arrays.stream(values1).boxed()).sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int[] sortedArray1 = IntStream.concat(Arrays.stream(values), Arrays.stream(values1)).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        String collect1 = str1.chars().mapToObj(i -> (char) i).map(String::valueOf).map(String::toUpperCase).collect(Collectors.joining());
        String collect = IntStream.range(0, str1.length()).mapToObj(i -> i % 2 != 0 ? 'X' : str1.charAt(i)).map(String::valueOf).collect(Collectors.joining());
        System.out.println(collect);
    }
}

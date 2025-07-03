package org.coreconcepts.collections.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayPractice {

    public static void main(String[] args) {
//      basicStringArrayPractice();
//      advanceLevelPractice();
        intStreamPractice();
    }

    private static void intStreamPractice() {int[] numbers = {12,22,67,32,75,29};
      int max =   Arrays.stream(numbers).max().getAsInt();
      int min = Arrays.stream(numbers).min().getAsInt();
      int sum = Arrays.stream(numbers).sum();
      double average = Arrays.stream(numbers).average().getAsDouble();
        System.out.println(average);
      int[] sortedArray = Arrays.stream(numbers).sorted().toArray();
      List<Integer> list = Arrays.stream(numbers).boxed().toList();
      List<Integer> list1 = Arrays.stream(sortedArray).boxed().toList();

        System.out.println(list1.get(2));
        System.out.println(list1);
    }


    private static void advanceLevelPractice() {
        String[] str = {"Welcome", "To","India","India is one of large population" ,"is","large country"};
        List<String> listString =  Arrays.stream(str).flatMap(s->Arrays.stream(s.split(" "))).toList();
        Map<String, Long> collect = Arrays.stream(str)
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    private static void basicStringArrayPractice() {
        String[] str = {"Welcome", "To","India","India is one of large population" ,"is","large country"};
        String myString = "Welcome To India India is one of large population large country";
        System.out.println(Arrays.toString(str));
        System.out.println(str.length);
        List<String> list = Arrays.stream(str).toList();
        List<String> list1 = Arrays.stream(str).map(String::toUpperCase).toList();
        List<String> t = Arrays.stream(str).filter(s -> s.startsWith("T")).toList();
        long count = Arrays.stream(str).count();
        List<String> list2 = Arrays.stream(str).sorted(Comparator.comparing(s -> s)).toList();
        List<String> list3 = Arrays.stream(str).sorted(Comparator.reverseOrder()).toList();
        String joining = Arrays.stream(str).collect(Collectors.joining("*"));
        String joining1 = String.join("%",str);
        Map<String, Long> groupBys = Arrays.stream(str).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        Arrays.stream(str).reduce((s1, s2) -> str.length < s2.length() ? s1 : s2).ifPresent(System.out::println);
        Map<String, Integer> strLengthMap = Arrays.stream(str).collect(Collectors.toMap(s -> s, String::length,(a,b)->b));
        Map<Integer, String> lengthStrMap = Arrays.stream(str).collect(Collectors.toMap(String::length, s -> s,(a,b)->a +","+ b));
//        Arrays.stream(str).forEach(System.out::println);
        Map<String, Integer> map = Arrays.stream(myString.split(" ")).collect(Collectors.toMap(s -> s, String::length, (a, b) -> a));
        Map<String, Long> collect = Arrays.stream(myString.split(" ")).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(collect);
    }
}

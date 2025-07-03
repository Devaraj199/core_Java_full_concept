package org.coreconcepts.general.codings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice2 {
    public static void main(String[] args) {
        String[] str = {"kw","apple","banana","pineappple","jackfruit","spt"};
//       Arrays.sort(str, Comparator.comparing(String::length));
        List<String> list = Arrays.stream(str).sorted(Comparator.comparingInt(String::length).reversed()).toList();
        Optional<String> max = Arrays.stream(str).max(Comparator.comparingInt(String::length));
//        List<String> list1 = Arrays.stream(str).filter(st -> st.matches(".*[aeiou]*.")).toList();
        List<String> list1 = Arrays.stream(str)
                .filter(st -> !st.matches(".*[aeiou].*")).toList();
        List<String> list2 =  Arrays.stream(str).filter(st-> st.contains("a") && st.contains("z")).toList(); // []
//        IntStream.range(0,str.length).mapToObj(i->str[str.length-1-i]).forEach(System.out::println);

        String s = "pineappple";
        String string = IntStream.range(0, s.length()).mapToObj(i -> s.charAt(s.length() - 1 - i)).collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();
        System.out.println(string);
        int[] xx = {23,44,55,66};
        String[] yy = {"1", "2", "3", "4", "5"};
        double sum = Arrays.stream(xx).mapToDouble(i->i).sum();
        long sum1 = Arrays.stream(xx).mapToLong(i->i).sum();
        int sum2 = Arrays.stream(yy).mapToInt(Integer::parseInt).sum();
        double[] array = Arrays.stream(yy).mapToDouble(Integer::valueOf).toArray();
        List<Integer> list11 = Arrays.asList(23,44,5,66,77,67);
        list11.stream().mapToInt(Integer::intValue).toArray();
        list11.stream().mapToLong(Integer::intValue).sum();
        double sum3 = list11.stream().mapToDouble(Integer::intValue).min().getAsDouble();
        Integer maxValue = list11.stream().max(Comparator.comparing(i->i)).get();
        int maxValue1 = list11.stream().max(Comparator.comparingInt(i->i)).get();
        Integer maxValue3 = list11.stream().max(Comparator.comparing(i->i)).get();
        int maxValue4 = list11.stream().max(Comparator.comparingInt(i -> i)).get();
        System.out.println(maxValue);

    }
}

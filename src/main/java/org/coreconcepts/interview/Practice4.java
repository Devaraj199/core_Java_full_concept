package org.coreconcepts.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice4 {
    public static void main(String[] args) {
        String s = "Bangladesh";
        Arrays.stream(s.split("")).map(res -> s.indexOf(res) % 2 != 0 ? "X" : res).collect(Collectors.joining());
        String collect = IntStream.range(0, s.length()).mapToObj(i -> i % 2 != 0 ? 'X' : s.charAt(i)).map(String::valueOf).collect(Collectors.joining());
        String removeVowels = "ppppeI";
        String vowels = "aeiou";
        Predicate<String> predicate = (stt)->"aeiou".contains(stt) || "AEIOU".contains(stt);
        String collect1 = Arrays.stream(removeVowels.split("")).filter(predicate).collect(Collectors.joining());
        String str = "welcome to my coding cure";
        Map<Character, Long> collect2 = str.chars().mapToObj(c -> (char) c).filter(c->c!=' ').collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<String, Long> collect3 = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String nonrepeatingChar = "fgfklg";
        Character hhf= nonrepeatingChar.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(hhf);
        List<String> list = Arrays.asList("Hello India", "Hello Bharat", "Bharat mahan");
        Map<String, Long> collect4 = list.stream().flatMap(ppp-> Arrays.stream(ppp.split(" "))).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        IntStream.range(0,s.length()).forEach(index-> System.out.println("Index: "+index +" value: "+s.charAt(index)));
        String collect5 = IntStream.range(0, s.length()).filter(i -> i % 2 == 0).mapToObj(s::charAt).map(String::valueOf).collect(Collectors.joining());
        String collect6 = s.chars().mapToObj(c -> (char) c).map(c -> s.indexOf(c) % 2 == 0 ? c : 'X').map(String::valueOf).collect(Collectors.joining());
        System.out.println(collect6);

        String collect7 = IntStream.range(0, s.length()).mapToObj(value -> s.length() - 1 - value).map(s::charAt).map(String::valueOf).collect(Collectors.joining());
        System.out.println("collect7 "+collect7);
        String reduce = IntStream.range(0, s.length()).mapToObj(value -> s.length() - 1 - value).map(s::charAt).map(String::valueOf).reduce("", String::concat);
        String sddd = "Customer";
        int middleIndex = sddd.length() / 2;

        String firstHalf = IntStream.range(0, middleIndex)
                .mapToObj(sddd::charAt)
                .map(String::valueOf)
                .reduce("", (a,b)->a+b);

        String secondHalf = IntStream.range(middleIndex, sddd.length())
                .mapToObj(sddd::charAt)
                .map(String::valueOf)
                .reduce("", String::concat);

        System.out.println("Original: " + s);
        System.out.println("First half: " + firstHalf);
        System.out.println("Second half: " + secondHalf);
        System.out.println(reduce);
    }

}

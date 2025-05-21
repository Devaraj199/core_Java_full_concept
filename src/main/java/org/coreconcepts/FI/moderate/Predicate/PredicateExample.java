package org.coreconcepts.FI.moderate.Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PredicateExample {
    public static void main(String[] args) {
        PredicateBasic();
//        predicateComposition();
//        biPredicateFunction();
//        PredicateWithCollectionsExample();
    }

    private static void PredicateWithCollectionsExample() {
        List<Person> people = Arrays.asList(
                new Person("John", 28, "Male"),
                new Person("Jane", 22, "Female"),
                new Person("Adam", 35, "Male"),
                new Person("Eve", 19, "Female"),
                new Person("Mike", 17, "Male"),
                new Person("Olivia", 32, "Female")
        );
        Predicate<Person> isMaleCheck = person -> person.gender.equals("Male");
        Predicate<Person> isAgeGreater25 = person -> person.age > 25;
        List<Person> list = people.stream().filter(isMaleCheck).toList();
        List<Person> list1 = people.stream().filter(isAgeGreater25.and(isMaleCheck)).toList();

        for(Person p: list1){
            System.out.println(p.name+"_"+ p.gender);
        }
    }

    private static void biPredicateFunction() {
        BiPredicate<Integer,Integer> isSumEven = (a,b) -> (a+b) % 2 == 0;
        BiPredicate<Integer,Integer> isSumDivideBy3 = (a,b) -> (a+b) % 3 == 0;
        System.out.println(isSumEven.and(isSumDivideBy3).test(14,24));
        BiPredicate<String,String> startsWith = String::startsWith;
        System.out.println(startsWith.test("Hello","He"));
    }

    private static void predicateComposition() {
        Predicate<String> hasLength5 = str -> str.length() == 5;
        Predicate<String> startWithA = str -> str.startsWith("A");
        System.out.println(hasLength5.and(startWithA).test("Apple")); // true
        System.out.println(hasLength5.and(startWithA.negate()).test("Apple")); // false
        System.out.println(hasLength5.or(startWithA).test("Bpples")); // false
        System.out.println(hasLength5.or(startWithA).test("Apples")); // true
    }

    public static void PredicateBasic() {
      Predicate<String> isEmpty = String::isEmpty;
      Predicate<String> isNotEmpty = str->!str.isEmpty();
      System.out.println(isEmpty.test(""));
      Predicate<Integer> isPositive = n -> n > 0;
      System.out.println(isPositive.test(-23));
      List<String> names = Arrays.asList("John", "", "Jane", "Adam", "");
      List<String> list = names.stream().filter(isNotEmpty).toList();
      System.out.println(list);
      IntPredicate isEven = n-> n%2==0;
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sumOfEvens = IntStream.of(numbers)
                .filter(isEven)
                .sum();
        System.out.println(sumOfEvens);
  }
}

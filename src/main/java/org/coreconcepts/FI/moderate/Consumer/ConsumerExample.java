package org.coreconcepts.FI.moderate.Consumer;

import org.coreconcepts.FI.moderate.Predicate.Person;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        basicConsumerExample();
    }

    private static void basicConsumerExample() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        Consumer<String> consumer = System.out::println;
        Consumer<String> nameWithUpperCase = str -> System.out.println(str.toUpperCase());
        Consumer<String> printLengthConsumer = s -> System.out.println("Length: " + s.length());
//        consumer.accept("Hello");
//        nameWithUpperCase.accept("Hello");
//        names.forEach(nameWithUpperCase);
//         nameWithUpperCase.andThen(printLengthConsumer).accept("Hello");
         Consumer<Person> personConsumer = person -> System.out.println(person.getName()+" " + person.getAge());
//         personConsumer.accept(new Person("Alice", 25,"Male"));
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25,"Male"));
        people.add(new Person("Bob", 30,"Male"));
        people.add(new Person("Charlie", 35,"Male"));
        people.forEach(personConsumer);
        // Bi Consumer
        Map<String,Integer> map = new HashMap<>();
        map.put("Alice",25);
        map.put("Bob",30);
        map.put("Charlie",35);

        BiConsumer<String,Integer> biConsumer = (a,b)-> {
            System.out.println(a+"***"+b);
        };
        map.forEach(biConsumer);
    }
}

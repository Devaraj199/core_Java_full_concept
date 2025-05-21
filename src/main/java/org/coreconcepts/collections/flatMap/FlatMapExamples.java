package org.coreconcepts.collections.flatMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExamples {
    public static void main(String[] args) {
//         basicFlatMapExamples();
//          advanceExamples();
           withCustomObjectExample();
    }

    private static void withCustomObjectExample() {
        Order order1 = new Order("Notebook");
        Order order2 = new Order("Pen");
        Order order3 = new Order("Laptop");
        List<Customer> customers = Arrays.asList(new Customer(Arrays.asList(new Order("Notebook"),new Order("Pen")))
                ,new Customer(Arrays.asList(new Order("Laptop"),new Order("Mobile"))));
        List<Order> orderList = customers.stream().flatMap(c -> c.getOrders().stream()).toList();
        List<String> listOfOrderStrings = orderList.stream().map(Order::getItem).toList();
        System.out.println(listOfOrderStrings);
    }

    private static void advanceExamples() {
        List<String> authors = Arrays.asList("Alice", "Bob");
        List<String> books = Arrays.asList("Book1", "Book2");
        List<String> list = authors.stream().flatMap(s -> books.stream().map(i -> s + " wrote " + i)).toList();
        List<String> authorBookPairs = authors.stream()
 .flatMap(author -> books.stream().map(book -> author + " wrote " + book))
 .toList();

        System.out.println(authorBookPairs);

    }

    private static void basicFlatMapExamples() {

       List<List<String>> list = Arrays.asList(Arrays.asList("Mohan","Kumar"),Arrays.asList("Babu","Kiran","Laden")) ;
        System.out.println(list); // [["Mohan","Kumar"],["Babu","Kiran","Laden"]]
        List<String> list1 = list.stream().flatMap(List::stream).toList();
        List<String> words = Arrays.asList("hello", "world");
        List<String> list2 = words.stream().flatMap(w -> Arrays.stream(w.split(""))).toList();
        List<String> sentences = Arrays.asList("Java is fun", "Streams are powerful");
        List<String> list3 = sentences.stream().flatMap(word -> Arrays.stream(word.split(" "))).map(String::toUpperCase).toList();
        System.out.println(list3);
    }
}

package org.coreconcepts.collections.list;

import org.coreconcepts.FI.moderate.Predicate.Person;

import java.util.*;

public class BasicListExample {
    public static void main(String[] args) {
//        listCreationExamples();
        listArrayConversion();
    }

    private static void listArrayConversion() {
        String[] colorsArray = {"Red", "Green", "Blue"};

        // Method 1: Using Arrays.asList()
        List<String> colorsList1 = Arrays.asList(colorsArray);
        System.out.println("List from array using Arrays.asList(): " + colorsList1);

        // Method 2: Using new ArrayList<>(Arrays.asList())
        // This creates a modifiable ArrayList
        List<String> colorsList2 = new ArrayList<>(Arrays.asList(colorsArray));
        colorsList2.add("Yellow"); // This works
        System.out.println("Modifiable list from array: " + colorsList2);

        // Method 3: Using List.of() (Java 9+)
        List<String> colorsList3 = List.of(colorsArray);
        System.out.println("Immutable list from array using List.of(): " + colorsList3);

        // Converting List to array
        List<String> fruitsList = new ArrayList<>();
        fruitsList.add("Apple");
        fruitsList.add("Banana");
        fruitsList.add("Cherry");

        // Method 1: Using toArray() with new array
        String[] fruitsArray1 = fruitsList.toArray(new String[0]);
        System.out.println("Array from list: " + Arrays.toString(fruitsArray1));

        // Method 2: Using toArray() with sized array
        String[] fruitsArray2 = fruitsList.toArray(new String[3]);
        System.out.println("Array from list (sized): " + Arrays.toString(fruitsArray2));

        // Method 3: Using toArray(IntFunction) (Java 11+)
        // String[] fruitsArray3 = fruitsList.toArray(String[]::new);
        // System.out.println("Array from list (Java 11+): " + Arrays.toString(fruitsArray3));
    }

    private static void listCreationExamples() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Elephant");
        linkedList.add("Fox");
        System.out.println("LinkedList: " + linkedList);

        // Creating a List with initial values
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("List from Arrays.asList(): " + numbers);
        // List.of() - creates immutable list (Java 9+)
        List<String> immutableList = List.of("Red", "Green", "Blue");
//        immutableList.add("Orange"); // UnsupportedOperationException
        System.out.println("Immutable List: " + immutableList);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30,"Male"));
        people.add(new Person("Bob", 25,"Male"));
        people.add(new Person("Charlie", 35,"Female"));
        people.sort(Comparator.comparing(Person::getGender));
        people.sort(Comparator.comparing(Person::getAge).reversed());
        people.forEach(a-> System.out.println(a.getName()));
    }
}

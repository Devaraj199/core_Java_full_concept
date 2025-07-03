package org.coreconcepts.javaFeatures;

import java.util.List;

public class General {
    public static void main(String[] args) {
    //    Stream.toList() Method
           List<Integer> integers = List.of(12, 34, 56);
    //         New String Methods
        String template = "Hello %s, you are %d years old";
        System.out.printf((template) + "%n", "Alice", 25);
        // repeat() - repeats string n times
        System.out.println("Java ".repeat(3));
        String multiline = "Line 1\nLine 2\nLine 3";
        // lines() - returns stream of lines
        multiline.lines()
                .map(line -> ">> " + line)
                .forEach(System.out::println);
        System.out.println("   ".isBlank()); // true
        System.out.println("Hello".isBlank()); // false
        enum Color { RED, GREEN, BLUE }

        Color color = Color.GREEN;

        // Match on the enum constant "color"
        switch (color) {
            // Match on the enum constant "RED"
            case RED -> System.out.println("The color is red.");
            // Match on the enum constant "GREEN"
            case GREEN -> System.out.println("The color is green.");
            // Match on the enum constant "BLUE"
            case BLUE -> System.out.println("The color is blue.");
        }

    }
}

package org.coreconcepts.general.immutable;

import java.util.ArrayList;
import java.util.List;

public class ImmutablePersonDemo {
    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Swimming");
        ImmutablePerson person = new ImmutablePerson("John Doe", 30, hobbies);
        System.out.println("Initial person: " + person);
        hobbies.add("Hiking");
        hobbies.remove("Swimming");
        System.out.println("After modifying original hobbies list (no effect on person): " + person);
        // Create a new person with a different name
        ImmutablePerson updatedPerson = person.withName("Jane Doe1");
        System.out.println("Original person (unchanged): " + person);
        System.out.println("New person with updated name: " + updatedPerson);
    }
}
//Make all fields final and private.
//Don't provide setters.
//Make the class final or make all constructors private and provide factory methods.
//If a field is a mutable object, make defensive copies in constructors and getters.
//        If needed, provide methods that create new instances with modified values.

package org.coreconcepts.javaFeatures;

public class RecordClass {
    public static void main(String[] args) {
        Person person = new Person("John Doe", 1, "john@example.com");
        System.out.println(person.name());     // John Doe
        System.out.println(person.age());      // 25
        System.out.println(person.email());    // john@example.com
        System.out.println(person.toString());
        System.out.println(person.isAdult());      // true
        System.out.println(person.getDisplayName());
    }
}

 record Person(String name, int age, String email) {

    // Compact constructor for validation
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }

    // Additional constructor
    public Person(String name, int age) {
        this(name, age, "");
    }

    // Custom methods
    public boolean isAdult() {
        return age >= 18;
    }

    public String getDisplayName() {
        return name.toUpperCase();
    }
}


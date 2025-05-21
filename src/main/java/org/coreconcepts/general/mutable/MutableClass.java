package org.coreconcepts.general.mutable;

import java.util.List;

public class MutableClass {
    public static void main(String[] args) {
        MutablePerson person = new MutablePerson("John Doe", 30, List.of("Reading","Dancing"));
        person.setAge(45);
        person.setHobbies(List.of("Singing","Reviewing"));
        System.out.println(person);
    }
}

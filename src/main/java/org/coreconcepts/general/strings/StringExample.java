package org.coreconcepts.general.strings;

public class StringExample {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3  = new String("Hello");
        String s4 = s3.intern(); // Moves to String pool
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("=======");
        System.out.println(s1 == s4);
        // Intern() method : Forces string to be store in the string pool, even it is creating using new
        // Helps to reduce duplicate objects and optimise memory.
        // compare references only not values(==) and equals() ---> checks contents
        // string literals are store in string constant pools


    }
}

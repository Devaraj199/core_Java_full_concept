package org.coreconcepts.wrapper_classes;

public class CharecterClass {
    public static void main(String[] args) {
        int i = Character.charCount(12);
        System.out.println(i);
        System.out.println(Character.isDigit('f'));
        System.out.println(Character.isLowerCase('F'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.valueOf('9'));
        System.out.println(Character.toUpperCase('b'));
        System.out.println(Character.toString('b'));
        System.out.println(Character.compare('e','b'));
        System.out.println(Character.getNumericValue('5'));
        System.out.println(Character.isLetterOrDigit('n'));
    }
}

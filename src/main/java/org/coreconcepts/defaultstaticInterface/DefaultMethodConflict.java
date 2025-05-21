package org.coreconcepts.defaultstaticInterface;

public class DefaultMethodConflict {
    public static void main(String[] args) {
        C c = new C();
        c.show();
    }
}

interface A {
    default void show() {
        System.out.println("Default show method from A");
    }
}

interface B {
    default void show() {
        System.out.println("Default show method from B");
    }
}
class C implements  B,A {


    @Override
    public void show() {
        System.out.println("C's own implementation of show");
        A.super.show();
    }
}


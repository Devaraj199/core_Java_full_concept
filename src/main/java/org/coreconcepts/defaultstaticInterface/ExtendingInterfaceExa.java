package org.coreconcepts.defaultstaticInterface;

public class ExtendingInterfaceExa {
    public static void main(String[] args) {
        Human human = new Human();
        human.eat();
        human.giveBirth();
        human.breathe();
        human.maintainBodyTemperature();
    }
}

interface Animal {
    void eat();

    default void breathe() {
        System.out.println("Animal is breathing");
    }

}

interface Mammal extends Animal {
    void giveBirth();

    // Override default method from parent interface
    @Override
    default void breathe() {
        System.out.println("Mammal is breathing with lungs");
    }

    // Add new default method
    default void maintainBodyTemperature() {
        System.out.println("Maintaining constant body temperature");
    }
}

class Human implements Mammal {
    @Override
    public void eat() {
        System.out.println("Human eats food");
    }

    @Override
    public void giveBirth() {
        System.out.println("Human gives birth to a baby");
    }

    // Uses default methods from Mammal
}



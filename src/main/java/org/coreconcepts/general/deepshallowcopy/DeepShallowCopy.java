package org.coreconcepts.general.deepshallowcopy;

import java.util.ArrayList;

public class DeepShallowCopy {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        Car original = new Car("Honda",colors);

        // Deep copy

        Car deepCopyHonda = new Car(original.name,original.colors);
        System.out.println(deepCopyHonda+" ----"+original);
        deepCopyHonda.colors.add("Green");

//        System.out.print("Deepcopy: ");
//        for (String color : deepCopyHonda.colors) {
//            System.out.print(color + " ");
//        }
//        System.out.println("\nOriginal: ");
//        for (String color : original.colors) {
//            System.out.print(color + " ");
//        }

//        Shallow Copy

        Car shallowCopy = original;
        shallowCopy.colors.add("Yellow");
        System.out.print("Shallow copy: ");
        for (String color : shallowCopy.colors) {
            System.out.print(color + " ");
        }
        System.out.println("\nOriginal: ");
        for (String color : original.colors) {
            System.out.print(color + " ");
        }

    }
}
class Car {
    public String name;
    public ArrayList<String> colors;

    public Car(String name, ArrayList<String> colors)
    {
        this.name = name;
        this.colors = colors;
    }
}

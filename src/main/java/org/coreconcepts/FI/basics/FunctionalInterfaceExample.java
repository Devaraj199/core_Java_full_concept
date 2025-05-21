package org.coreconcepts.FI.basics;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
//        1. Anonymous Inner Clas
        MyFuncInterface1 myFuncInterface = new MyFuncInterface1(){
          @Override
            public void display() {
              System.out.println("This is my first functional interface");
          }
        };
//        2. Lambda Expression
        MyFuncInterface1 myFuncInterface1 = () -> System.out.println("This my second functional interface");
//        3. Method reference
        MyFuncInterface1 myFuncInterface2 = FunctionalInterfaceExample::staticMethod;
//        4. Instance Method
        FunctionalInterfaceExample functionalInterfaceExample = new FunctionalInterfaceExample();
        MyFuncInterface1 myFuncInterface3 = functionalInterfaceExample::instanceMethod;
        myFuncInterface.display();
        myFuncInterface1.display();
        myFuncInterface2.display();
        myFuncInterface3.display();
    }

    public static void staticMethod() {
        System.out.println("Static method reference implementation");
    }
    public void instanceMethod() {
        System.out.println("Instance method reference implementation");
    }

}

@FunctionalInterface
interface MyFuncInterface1 {
    public void display();
}


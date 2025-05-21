package org.coreconcepts.defaultstaticInterface;

public class DefaultStaticExample {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.honk(); // override honk
        MotorCycle motorCycle = new MotorCycle();
        motorCycle.start();
        motorCycle.honk(); // default one
        System.out.println("Cars have " + Vehicle.getWheelCount("car") + " wheels");
        System.out.println("Motorcycles have " + Vehicle.getWheelCount("motorcycle") + " wheels");
    }
}

class Car implements Vehicle{

    @Override
    public void start() {
        System.out.println("Car engine started");
    }

    @Override
    public void honk() {
        System.out.println("Car horn: HONK HONK!");
    }
}

class MotorCycle implements Vehicle{

    @Override
    public void start() {
        System.out.println("Motorcycle engine started");
    }

}
interface  Vehicle {
    void start(); // Abstract Method
    default void honk() {
        System.out.println("Beep Deep!");
    }
    static int getWheelCount(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car": return 4;
            case "motorcycle": return 2;
            case "tricycle": return 3;
            default:return 0;
        }
    }
}

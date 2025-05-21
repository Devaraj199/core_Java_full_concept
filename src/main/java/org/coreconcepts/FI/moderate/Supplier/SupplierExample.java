package org.coreconcepts.FI.moderate.Supplier;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        basicSupplierExample();
    }

    private static void basicSupplierExample() {
        Supplier<String> supplier = () -> "Hello world";
        System.out.println(supplier.get());
        Supplier<Integer> integerSupplier = () -> 10 * 23;
        System.out.println(integerSupplier.get());
        Supplier<Long> longSupplier = System::currentTimeMillis;
        System.out.println(longSupplier.get());
        Supplier<Integer> randomValues = () -> new Random().nextInt(100);
        System.out.println(randomValues.get());

        Supplier<List<String>> listSupplier = () -> List.of("Apple","Banana","Mango");
        List<String> fruits = listSupplier.get();
        Supplier<UUID> supplier1 = UUID::randomUUID;
        Supplier<StringBuilder> stringBuilderSupplier = StringBuilder::new;
        StringBuilder sb = stringBuilderSupplier.get();
        sb.append("Hello, Supplier with constructor reference!");
        System.out.println(sb);
        System.out.println(supplier1.get());
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 85);

        Supplier<Integer> defaultScoreSupplier = () -> 80;
        Integer score = scores.getOrDefault("Raju",defaultScoreSupplier.get());
        System.out.println(score);

        IntSupplier randomIntSupplier = () -> new Random().nextInt(100);
        System.out.println("Random int: " + randomIntSupplier.getAsInt());

        BooleanSupplier coinFlipSupplier = () -> new Random().nextBoolean();
        System.out.println("Coin flip result: " + (coinFlipSupplier.getAsBoolean() ? "Heads" : "Tails"));

    }
}

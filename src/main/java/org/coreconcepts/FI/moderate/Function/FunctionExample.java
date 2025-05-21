package org.coreconcepts.FI.moderate.Function;

import java.util.function.*;

public class FunctionExample {
    public static void main(String[] args) {
//       basicFunctionExample();
//       FunctionComposition();
//         BiFunctionExample();
//        PrimitiveFunctionExample();
        OperatorExample();
    }

    private static void OperatorExample() {
        UnaryOperator<String> unaryOperator = str -> "Hello :"+str;
        BinaryOperator<String> binaryOperator = (s1,s2) -> s1 + "_"+s2;
        System.out.println(unaryOperator.apply("Devaraj"));
        System.out.println(binaryOperator.apply("Devaraj","Pradhan"));
        BinaryOperator<Integer> binaryOperator1 = BinaryOperator.maxBy(Integer::compare);
        BinaryOperator<Integer> binaryOperator2 = BinaryOperator.minBy(Integer::compare);
        System.out.println(binaryOperator1.apply(10,34));
        System.out.println(binaryOperator2.apply(10,34));
    }


    private static void PrimitiveFunctionExample() {
        IntFunction<String> intFunction = i -> "Result is: "+i;
        System.out.println(intFunction.apply(12));
        DoubleFunction<String> longFunction = value -> "Result is: "+value;
        System.out.println(longFunction.apply(1233333));
        ToIntFunction<String> toIntFunction = String::length;
        System.out.println(toIntFunction.applyAsInt("Hello"));

        // ToLongFunction - takes generic type, returns long
        ToLongFunction<String> stringToLong = Long::parseLong;
        System.out.println(stringToLong.applyAsLong("123456789"));
        ToDoubleFunction<String> stringToDouble = Double::parseDouble;
        System.out.println(stringToDouble.applyAsDouble("123.45"));
    }

    private static void BiFunctionExample() {
        BiFunction<Integer, Integer,Integer> biFunction1 = Integer::sum;
        BiFunction<String, String,String> biFunction2 = (a,b) -> a + "_" + b;
        BiFunction<String,String,Integer> biFunction3 = (a,b)-> (a+b).length();
        System.out.println(biFunction1.apply(56,23));
        System.out.println(biFunction2.apply("Hello","World"));
        System.out.println(biFunction3.apply("Hello","World"));
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> convertToString = i -> "Result: " + i;
        String result = multiply.andThen(convertToString).apply(5,6);
        System.out.println(result);

    }

    private static void FunctionComposition() {
        Function<Integer, Integer> function1 = value -> value *2;
        Function<Integer, Integer> function2 = value -> value +3;
        Function<Integer, Integer> combineFunction  = function1.andThen(function2); // 23
//        Function<Integer, Integer> combineFunction  = function1.compose(function2); 26
        System.out.println(combineFunction.apply(10));
    }

    private static void basicFunctionExample() {
        Function<String,Integer> function =String::length;
        int length = function.apply("Hello");
        Function<Integer, Boolean> function1 = value -> value%2==0;
        Boolean isEven = function1.apply(237);
        Function<Integer,String> function2 = value-> "Number is: "+value;
        System.out.println(isEven);
        System.out.println(function2.apply(233));


    }
}

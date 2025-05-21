package org.coreconcepts.collections.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListPractice {
    public static void main(String[] args) {
//        simpleListPractice();
//        simpleListWithString();
        listWithCustomObject();
    }

    private static void simpleListWithString() {
        List<String> stringList = List.of(
                "apple", "banana", "Orange", "Pineapple", "strawberry",
                "kiwi", "Mango", "apple", "Blueberry", "pear"
        );

        // 1. Filter strings that start with uppercase letters
        List<String> uppCaseList = stringList
                .stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .toList();
        // 2. Convert all strings to uppercase
        List<String> uppCaseList1 = stringList.stream().map(String::toUpperCase).toList();
        // 3. Filter strings with length greater than 5
        List<String> moreThan5List = stringList.stream().filter(str -> str.length() > 5).toList();
        // 5. Remove duplicates
        List<String> uniqueList = stringList.stream().distinct().toList();
        // 6. Get first 3 strings

        List<String> limitList = stringList.stream().limit(3).toList();
        // 7. Skip first 5 strings
        List<String> skipList = stringList.stream().skip(5).toList();
        // 8. Count strings that contain the letter 'a'
        long count = stringList.stream().filter(s -> s.toLowerCase().contains("a")).count();
        // 9. Join string with comma
        String joinComma = stringList.stream().collect(Collectors.joining(","));
        // 10. Group strings by their first letter
        // 11. Find any string that starts with 'b'
        List<String> startWithB = stringList.stream().filter(s -> s.startsWith("b")).toList();
        // 12. Check if all strings have length > 2
        boolean allMatch = stringList.stream().allMatch(s -> s.length() > 2);
        // 13. Check if any string has length > 10
        boolean anyMatch = stringList.stream().anyMatch(s->s.length()>10);
        // 14. Get the longest string
        String longestString = stringList.stream().reduce((s1,s2)-> s1.length() > s2.length() ? s1: s2).get();
        // 15. Get frequency of each string
        Map<String, Long> frequency = stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // 16. Filter and transform in one operation
        stringList.stream().filter(s->s.startsWith("a")).map(String::toUpperCase).toList();
        // 17. Partition strings by length > 5
        Map<Boolean, List<String>> partioningBy = stringList.stream().collect(Collectors.partitioningBy(s -> s.length() > 5));
        // 18. Convert to a map with string as key and length as value
        Map<String, Integer> strLengthMap = stringList.stream().collect(Collectors.toMap(Function.identity(), String::length,(a,b)->a));
        List<Character> charList = stringList.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c)).toList();
        System.out.println(charList);
    }

    private static void listWithCustomObject() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("E001", "John Doe", "Software Engineer", 75000L, "IT"));
        employees.add(new Employee("E002", "Jane Smith", "Project Manager", 90000L, "IT"));
        employees.add(new Employee("E003", "Peter Brown", "QA Engineer", 65000L, "QA"));
        employees.add(new Employee("E004", "Emily Davis", "Business Analyst", 80000L, "QA"));
        employees.add(new Employee("E005", "Chris Johnson", "HR Manager", 85000L, "HR"));
         // Calculate average salary
        long sum = employees.stream().mapToLong(Employee::getEmpSalary).sum();
        // 4. Find highest paid employee
         employees.stream().min(Comparator.comparing(Employee::getEmpSalary)).ifPresent(a-> System.out.println(a.getEmpName()));
         employees.stream().max(Comparator.comparing(Employee::getEmpSalary)).ifPresent(a-> System.out.println(a.getEmpName()));
//       Group employees by department

        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getEmpDept));
//        Get all employee names as a comma-separated string
        String collect1 = employees.stream().map(Employee::getEmpName).collect(Collectors.joining(","));
//         Count employees by department
        Map<String, Long> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.counting()));
//        Calculate total salary budget
        employees.stream().mapToLong(Employee::getEmpSalary).sum();
// Find employees whose names start with 'J'

        List<Employee> a = employees.stream().filter(emp -> emp.getEmpName().startsWith("J")).toList();
        // Sort employees by salary (descending)
        List<Employee> list = employees.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed()).toList();
//        Partition employees by salary threshold and calculate statistics for each group
//        Calculate percentage of total salary budget allocated to each department
//
//        Find the most common first letter in employee names by department
//        Calculate cumulative salary if we go through employees in order of their IDs
//        Find departments where all employees earn above a certain threshold
//        Create a custom collector to find median salary by department

//        Find the department with the highest average salary
       employees.stream()
               .collect(Collectors.groupingBy(Employee::getEmpDept,
                       Collectors.averagingDouble(Employee::getEmpSalary)))
               .entrySet().
               stream()
               .max(Map.Entry.comparingByValue())
               .ifPresent(System.out::println);

//       Find the  highest salary in each department
        Map<String, Optional<Employee>> collect3 = employees.stream().
                collect(Collectors.groupingBy(Employee::getEmpDept,
                        Collectors.maxBy(Comparator.comparingLong(Employee::getEmpSalary))));
//        Find the second highest salary in each department
        Map<String, Optional<Employee>> collect4 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getEmpDept,
                        Collectors.collectingAndThen(Collectors.toList(), list1 -> list1.stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary).reversed()).skip(1).findFirst())));
//        System.out.println(collect4);
//        Find employees with salary higher than their department's average
        Map<String, Double> avgSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getEmpDept,Collectors.averagingLong(Employee::getEmpSalary)));
        System.out.println(avgSalaryByDept);
        List<Employee> list1 = employees.stream().filter(emp -> emp.getEmpSalary() >
                avgSalaryByDept.get(emp.getEmpDept())).toList();
        System.out.println(list1);
        Map<String, List<String>> collect5 = employees.stream().collect(Collectors.groupingBy(Employee::getEmpDept,
                Collectors.collectingAndThen(Collectors.mapping(e->e.getEmpName().toUpperCase(), Collectors.toList()),Collections::unmodifiableList)));
        System.out.println(collect5);
    }


    private static void simpleListPractice() {
        List<Integer> integerList = List.of(25,24,87,76,46);
        int sum = integerList.stream().mapToInt(Integer::intValue).sum();
        double v = integerList.stream().mapToInt(Integer::intValue).average().orElse(0);
        int min = integerList.stream().mapToInt(Integer::intValue).min().getAsInt();
        int max = integerList.stream().mapToInt(Integer::intValue).max().getAsInt();
        List<Integer> sortedList = integerList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sum: "+sum);
        System.out.println("Average: "+v);
        System.out.println("Min: "+min+"Max: "+max);
        System.out.println(sortedList);
//        integerList.stream().filter(i->i%2==0).findFirst().ifPresent(System.out::println);
//        integerList.stream().filter(i->i%2==0).skip(2).forEach(a-> System.out.println(a));
//        integerList.stream().map(i->i*2).forEach(System.out::println);
        List<String> stringList = integerList.stream().map(String::valueOf).toList();
        System.out.println(stringList);
        List<Integer> firstDigitEven = integerList.stream().filter(n -> {
            char firstChar = Integer.toString(n).charAt(0);
            int value = Character.getNumericValue(firstChar);
            return value % 2 == 0;
        }).toList();
        System.out.println(firstDigitEven);
    }
}

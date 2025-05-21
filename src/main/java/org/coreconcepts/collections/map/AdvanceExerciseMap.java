package org.coreconcepts.collections.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdvanceExerciseMap {
    public static void main(String[] args) {
//        differentMapCreation();
//        practiceProblemsOnMap();
          practiceProblemsOnMap1();
    }

    private static void practiceProblemsOnMap1() {
        Map<Employee,Integer> empMap = AdvanceExerciseMap.customObjectAsKey();
        LinkedHashMap<Employee, Integer> collect = empMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a2, LinkedHashMap::new));
        collect.forEach((k,v)-> System.out.println(k.empName + "__" +v));
        LinkedHashMap<Employee, Integer> collect1 = empMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a2, LinkedHashMap::new));
//        collect1.forEach((k,v)-> System.out.println(k.empName + "__" +v));
        empMap.entrySet().stream().min(Map.Entry.comparingByValue()).ifPresent(e-> System.out.println(e.getKey().empName));


    }

    private static void practiceProblemsOnMap() {
        Map<Employee,Integer> empMap = AdvanceExerciseMap.customObjectAsKey();
        // Using java 8 stream
        // Example 1: Find employees with salary greater than 20000
//          empMap.entrySet().stream().filter(entry->entry.getKey().empSalary>20000).forEach(entry -> System.out.println(entry.getKey().empName));
        // Example 2: Find the employee with the highest salary
//         empMap.entrySet().stream().max(Comparator.comparing(entry -> entry.getKey().empSalary)).ifPresent(entry-> System.out.println(entry.getKey().empName));
//         empMap.keySet().stream().max(Comparator.comparing(Employee::getEmpSalary)).ifPresent(e-> System.out.println(e.empName));
//         empMap.entrySet().stream().min(Comparator.comparing(entry->entry.getKey().empSalary)).ifPresent(entry-> System.out.println(entry.getKey().empName));
//         empMap.keySet().stream().min(Comparator.comparing(Employee::getEmpSalary)).ifPresent(e-> System.out.println(e.empName));
//           empMap.keySet().stream().sorted(Comparator.comparing(Employee::getEmpName)).forEach(employee -> System.out.println(employee.empName));
//             empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpName))).forEach(entry-> System.out.println(entry.getKey().empName + "__"+entry.getValue()));
//             empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getEmpName).reversed())).forEach(entry-> System.out.println(entry.getKey().empName + "__"+entry.getValue()));

        // Example 3: Calculate the average salary of all employees
        double v = empMap.keySet().stream().mapToInt(Employee::getEmpSalary).average().orElse(0.0);
        int sum = empMap.keySet().stream().mapToInt(Employee::getEmpSalary).sum();
        System.out.println(sum);
//        System.out.println(v);

        // Example 4: Group employees by designation
        Map<String, List<Employee>> byDesignation = empMap.keySet().stream().collect(Collectors.groupingBy(Employee::getEmpName));
        byDesignation.forEach((designation, employees) -> {
//            System.out.println(designation + ":");
//            employees.forEach(emp -> System.out.println("  " + emp));
        });
        // Example 5: Count employees by designation
      Map<String,Long> counting =  empMap.keySet().stream().collect(Collectors.groupingBy(Employee::getEmpDesignation,Collectors.counting()));
        System.out.println(counting);
        // Example 10: Find if any employee has salary less than 20000
        boolean b = empMap.keySet().stream().anyMatch(employee -> employee.getEmpSalary() < 20000);
        System.out.println(b);

        // Example 6: Convert to a map of employee name to salary
         Map<String,Integer> nameToSalary =   empMap.keySet().stream().collect(Collectors.toMap(Employee::getEmpName,Employee::getEmpSalary));
//        System.out.println(nameToSalary);

        // Example 7: Find employees with the same salary
         Map<Integer,List<Employee>> bySalary =  empMap.keySet().stream().collect(Collectors.groupingBy(Employee::getEmpSalary));
        bySalary.forEach((salary,value)->{
            if(value.size()>1)
            {
                System.out.println("Salary " + salary + ":");
                value.forEach(emp -> System.out.println("  " + emp.getEmpName()));
            }
        });
        // Example 8: Create a list of all employee names in uppercase
      List<String> upperCaseNames =   empMap.keySet().stream().map(employee -> employee.getEmpName().toUpperCase()).toList();
        System.out.println(upperCaseNames);


    }

    private static  Map<Employee, Integer> customObjectAsKey() {
        Map<Employee, Integer> empMap = new HashMap<>();
        empMap.put(new Employee("Raju","Developer",25000),1);
        empMap.put(new Employee("Mohan","Tester",35000),3);
        empMap.put(new Employee("Mahesh","Engineer",35000),7);
        empMap.put(new Employee("Kumar","Lead",45000),2);
        return empMap;
    }

    private static void differentMapCreation() {
        // Hashmap order is not guarantee
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("fruit1", "Apple");
        hashMap.put("fruit2", "Banana");
        hashMap.put(null, "No fruit");
//        System.out.println("HashMap: " + hashMap);
        // Linked Hash map (insertion order)
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("fruit1", "Apple");
        linkedHashMap.put("fruit2", "Banana");
        linkedHashMap.put(null, "No fruit");
//        System.out.println("HashMap: " + linkedHashMap);

        // Tree Map sorting based on keys no null keys
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("fruit3", "Pineapple");
        treeMap.put("fruit1", "Apple");
        treeMap.put("fruit2", "Banana");
        System.out.println("HashMap: " + treeMap);

        // ConcurrentHashMap - thread-safe operations order is not guarantee
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("fruit1", "Apple");
        concurrentHashMap.put("fruit2", "Banana");
        System.out.println("ConcurrentHashMap: " + concurrentHashMap);
    }
}

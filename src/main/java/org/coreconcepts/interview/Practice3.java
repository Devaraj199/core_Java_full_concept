package org.coreconcepts.interview;

import org.coreconcepts.interview.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Practice3 {
    public static void main(String[] args) {
        Map<String, Employee> employeeMap = EmployeeInfo.getEmployeeMap();
        String empName = employeeMap.entrySet().stream().max(Map.Entry.comparingByValue(Comparator.comparing(Employee::getEmpSalary))).get().getValue().getEmpName();
        String minName = employeeMap.entrySet().stream().min(Map.Entry.comparingByValue(Comparator.comparing(Employee::getEmpSalary))).get().getValue().getEmpName();
        String maxEmpName = employeeMap.values().stream().max(Comparator.comparingLong(Employee::getEmpSalary)).get().getEmpName();
        String minEmpName = employeeMap.values().stream().min(Comparator.comparingLong(Employee::getEmpSalary)).get().getEmpName();
        Map<String, List<Employee>> collect = employeeMap.values().stream().collect(Collectors.groupingBy(Employee::getEmpDept));
        Map<String, List<String>> collect1 = employeeMap.entrySet().stream()
                .collect(Collectors.groupingBy(entry -> entry.getValue().getEmpDept(), Collectors.mapping(entry -> entry.getValue().getEmpName(), Collectors.toList())));
        Map<String, Optional<Long>> collect2 = employeeMap.values().stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingLong(Employee::getEmpSalary)), o -> o.map(Employee::getEmpSalary))));
        Map<String, Double> collect3 = employeeMap.values().stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.summingDouble(Employee::getEmpSalary)));
        LinkedHashMap<String, Employee> collect4 = employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        Map<String, Double> collect5 = employeeMap.entrySet().stream().collect(Collectors.groupingBy(emp -> emp.getValue().getEmpDept(), Collectors.averagingLong(emp -> emp.getValue().getEmpSalary())));
        Map<String, Double> collect6 = employeeMap.values().stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.summingDouble(Employee::getEmpSalary)));
        Map<String, Long> collect7 = employeeMap.values().stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getEmpSalary)), o -> o.map(Employee::getEmpSalary).orElse(0L))));
        Map<String, String> collect8 = employeeMap.values().stream()
                .collect(Collectors.toMap(Employee::getEmpDept, Employee::getEmpName,(e1,e2)->e1));
        System.out.println(collect8);
        List<Integer> integerList = Arrays.asList(23,45,3,45,23,67);
        List<Integer> integerList1 = new ArrayList<>();
        for(Integer value:integerList){
            if(!integerList1.contains(value)){
                integerList1.add(value);
            }
        }
        System.out.println(integerList1);
    }
}

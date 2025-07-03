package org.coreconcepts.interview;

import org.coreconcepts.interview.model.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Practice2 {
    public static void main(String[] args) {
        List<Employee>  employeesList = EmployeeInfo.getEmployeeList();
        List<String> empNames = employeesList.stream().map(Employee::getEmpName).toList();
        List<Employee> sortedList = employeesList.stream().sorted(Comparator.comparing(Employee::getEmpName).reversed()).toList();
        Employee employee = employeesList.stream().min(Comparator.comparingLong(Employee::getEmpSalary)).get();
        Long totalSalary = employeesList.stream().mapToLong(Employee::getEmpSalary).sum();
        Double average = employeesList.stream().mapToLong(Employee::getEmpSalary).average().getAsDouble();
        System.out.println(average);
        Map<String, List<Employee>> group1 = employeesList.stream().collect(Collectors.groupingBy(Employee::getEmpDesignation));
        Map<String, List<String>> group2 = employeesList.stream().collect(Collectors.groupingBy(Employee::getEmpDesignation, Collectors.mapping(Employee::getEmpName, Collectors.toList())));
        Map<String, List<String>> group3 = employeesList.stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.mapping(Employee::getEmpName, Collectors.toList())));
        Map<String, Double> group4 = employeesList.stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.averagingLong(Employee::getEmpSalary)));
        Map<String, Optional<Employee>> group5 = employeesList.stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.maxBy(Comparator.comparingLong(Employee::getEmpSalary))));
        Map<String, Long> group6 = employeesList.stream().collect(Collectors.groupingBy(Employee::getEmpDept, Collectors.reducing(0L, Employee::getEmpSalary, Long::max)));
        Map<String, Long> group7 = employeesList.stream()
                .collect(Collectors.groupingBy(
                        Employee::getEmpDept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingLong(Employee::getEmpSalary)),
                                o->o.map(Employee::getEmpSalary).orElse(0L)
                        )
                ));
        Predicate<Employee> predicate = (emp)->emp.getEmpSalary()>=85000;
        Predicate<Employee> predicate1 = (employee1)->employee1.getEmpSalary()<=70000;
        Map<Boolean, List<String>> partitioning = employeesList.stream().collect(Collectors.partitioningBy(predicate.and(predicate1), Collectors.mapping(Employee::getEmpName, Collectors.toList())));
        System.out.println(partitioning);
    }
}

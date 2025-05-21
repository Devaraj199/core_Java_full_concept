package org.coreconcepts.comprableandConparator;

import java.util.*;

public class ComparableComparatorDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(103, "Alice", 75000.0, 32));
        employees.add(new Employee(102, "Diana", 72000.0, 28));
        employees.add(new Employee(104, "Eve", 95000.0, 40));
        employees.add(new Employee(105, "Charlie", 85000.0, 35));
        employees.add(new Employee(101, "Bob", 65000.0, 28));

        // Comparable
//        Collections.sort(employees);
//       employees.forEach((value)-> {
//           System.out.println(value.getSalary());
//       });

//        Comparator
//        employees.sort(new EmployeeComparators.NameComparator());
//        employees.sort(new EmployeeComparators.AgeAndSalaryComparator());
//        employees.sort(Comparator.comparing(e->e.getName().length()));
        employees.sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getSalary));
        employees.forEach((value)-> {
           System.out.println(value.getName());
       });
    }


}

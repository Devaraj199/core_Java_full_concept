package org.coreconcepts.interview;



import org.coreconcepts.interview.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeInfo {
    public static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("E001", "John Doe", "Software Engineer", 75000L, "IT"));
        employees.add(new Employee("E002", "Jane Smith", "Project Manager", 90000L, "IT"));
        employees.add(new Employee("E003", "Peter Brown", "QA Engineer", 65000L, "QA"));
        employees.add(new Employee("E004", "Emily Davis", "Business Analyst", 80000L, "Business"));
        employees.add(new Employee("E005", "Chris Johnson", "HR Manager", 85000L, "HR"));
        return employees;
    }
    public static Map<String, Employee> getEmployeeMap() {
        Map<String, Employee> employeeMap = new HashMap<>();
        employeeMap.put("E001", new Employee("E001", "John Doe", "Software Engineer", 75000L, "IT"));
        employeeMap.put("E002", new Employee("E002", "Jane Smith", "Project Manager", 90000L, "IT"));
        employeeMap.put("E003", new Employee("E003", "Peter Brown", "QA Engineer", 65000L, "QA"));
        employeeMap.put("E004", new Employee("E004", "Emily Davis", "Business Analyst", 80000L, "Business"));
        employeeMap.put("E005", new Employee("E005", "Chris Johnson", "HR Manager", 85000L, "HR"));
        return employeeMap;
    }


}

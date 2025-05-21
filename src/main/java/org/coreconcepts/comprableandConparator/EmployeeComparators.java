package org.coreconcepts.comprableandConparator;

import java.util.Comparator;

public class EmployeeComparators {

    public static class NameComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public static class AgeComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getAge(),o2.getAge());
        }
    }

    public static class SalaryDescendingComparator  implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o1.getSalary(),o2.getSalary());
        }
    }
    public static class AgeAndSalaryComparator   implements Comparator<Employee>{
        @Override
        public int compare(Employee o1, Employee o2) {
            int ageCompare = Integer.compare(o1.getAge(),o2.getAge());
            if(ageCompare!=0){
                return ageCompare;
            }
            return Double.compare(o1.getSalary(),o2.getSalary());
        }
    }
}

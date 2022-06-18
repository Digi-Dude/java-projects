package Comparators;

import Staff.Employee;

import java.util.Comparator;

public class LowComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getMonthSalary(), o2.getMonthSalary());
    }
}

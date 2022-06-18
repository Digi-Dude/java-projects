import org.checkerframework.checker.units.qual.C;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
//        staff.forEach(employee -> System.out.println(employee.getWorkStart()));
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year

        return staff.stream()
                .filter(employee -> {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(employee.getWorkStart());
                    return calendar.get(Calendar.YEAR) == year;
                })
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
}
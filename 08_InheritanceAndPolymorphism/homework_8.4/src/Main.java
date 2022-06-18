import Staff.*;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Company cocaCola = new Company(180, 80, 10);

        System.out.println(cocaCola.getIncome());

        for(Employee employee: cocaCola.getTopSalaryStaff(12)) {
            System.out.println(employee);
        }
        System.out.println();
         for(Employee employee: cocaCola.getLowestSalaryStaff(30)) {
             System.out.println(employee);
        }
        System.out.println();
        System.out.println();
        cocaCola.fireAll(cocaCola.employeeOnFire(135));
        for(Employee employee: cocaCola.getTopSalaryStaff(12)) {
            System.out.println(employee);
        }
        System.out.println();
        System.out.println();
        for(Employee employee: cocaCola.getLowestSalaryStaff(30)) {
            System.out.println(employee);

        }
    }
}

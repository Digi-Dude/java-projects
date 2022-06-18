package Staff;
import Comparators.LowComparator;
import Comparators.TopComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    public Company(int operators, int managers, int topManagers) {
        for (int i = 0; i < operators; i++) {
            this.staff.add(new Operator(18000, Company.this));
        }
        for (int i = 0; i < managers; i++) {
            this.staff.add(new Manager(30000, Company.this));
        }
        for (int i = 0; i < topManagers; i++) {
            this.staff.add(new TopManager(45000, Company.this));
        }


    }

    private List<Employee> staff = new ArrayList<>();
    private int income = 0;
    protected void setIncome(int income) {this.income += income;
    }

    public void hire (Employee employee) {staff.add(employee);
    }

    public void hireAll(List<Employee> list) {
       for (int i = 0; i < list.size(); i++) {
           hire(list.get(i));
       }
    }

    public void fire (Employee employee) {staff.remove(employee);}

    public void fireAll(List<Employee> list) {
       staff.removeAll(list);
    }

    public List<Employee> employeeOnFire(int count) {
        List<Employee> employeeOnFire = new ArrayList();
        for (int i = 0; i < staff.size(); i++) {

            if (i % 2 == 0) {
                employeeOnFire.add(staff.get(i));
            }
        }
        return employeeOnFire;
    }

    public int getIncome() {
        return income;
    }



    public List<Employee> getTopSalaryStaff(int count) {
        staff.sort(new TopComparator());
        List<Employee> list = new ArrayList<>();
        if (isValidCount(count)) {
            for (int i = 0; i < count; i++) {
                list.add(staff.get(i));
            }
            return list;
        }
        else return Collections.EMPTY_LIST;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        staff.sort(new LowComparator());
        List<Employee> list = new ArrayList<>();
        if (isValidCount(count)) {
            for (int i = 0; i < count; i++) {
                list.add(staff.get(i));
            }
            return list;
        }
        else return Collections.EMPTY_LIST;
    }

    private boolean isValidCount(int count) {
        return count > 0 && count <= staff.size();
    }

}

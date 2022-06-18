package Staff;
import java.text.DecimalFormat;

public class TopManager implements Employee  {
    private int salary;
    private int monthSalary;
    private final Company company;

    public TopManager(int salary, Company company) {
        this.salary = salary;
        this.company = company;
        if(company.getIncome() >= 10000000) {
            this.monthSalary = (int) (this.salary + this.salary * 1.5);
        }
    }



    @Override
    public int getMonthSalary() {
        return monthSalary;
    }

    @Override
    public String toString() {
        return new DecimalFormat( "###,###" ).format(monthSalary) + " руб";
    }


    public Company getCompany() {
        return company;
    }
}

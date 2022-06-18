package Staff;
import java.text.DecimalFormat;

public class Operator implements Employee{
    private int monthSalary;
    private final Company company;
    public Operator(int salary, Company company) {
        this.company = company;
        this.monthSalary =salary;
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

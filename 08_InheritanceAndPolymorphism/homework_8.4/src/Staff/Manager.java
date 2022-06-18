package Staff;
import java.text.DecimalFormat;

public class Manager implements Employee{
    private final int monthSalary;
    private final Company company;
    public Manager(int salary, Company company) {
        this.company = company;
        int incomeForTheCompany = (int) (115000 + 25000 * Math.random());
        company.setIncome(incomeForTheCompany);
        this.monthSalary = (int) (salary + incomeForTheCompany * 0.05);

    }

    @Override
    public String toString() {
        return new DecimalFormat( "###,###" ).format(monthSalary) + " руб";
    }

    @Override
    public int getMonthSalary() {
        return monthSalary;
    }

    public Company getCompany() {
        return company;
    }
}

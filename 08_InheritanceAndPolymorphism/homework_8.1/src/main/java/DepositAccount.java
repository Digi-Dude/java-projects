import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome = LocalDate.of(2021, 4, 21);

    @Override
    public boolean take(double amountToTake) {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.minusMonths(1).isAfter(lastIncome)) {
            if (amountToTake < amount && amountToTake > 0) {
                amount -= (amountToTake) ;
                lastIncome = LocalDate.now();
                return true;
            }
            else return false;
        }
        else return false;
    }
}

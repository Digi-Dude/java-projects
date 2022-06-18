public class CardAccount extends BankAccount {
    @Override
    public boolean take(double amountToTake) {
        if (amountToTake < amount && amountToTake > 0) {
            amount -= (amountToTake + amountToTake * 0.01) ;
            return true;
        }
        else return false;
    }
}

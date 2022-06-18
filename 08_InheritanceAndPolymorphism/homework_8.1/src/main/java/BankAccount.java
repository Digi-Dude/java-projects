public class BankAccount {

  protected double amount;

  public double getAmount() {
    //TODO: реализуйте метод и удалите todo

    return this.amount;
  }

  public void put(double amountToPut) {
    //TODO: реализуйте метод и удалите todo
    if (amountToPut > 0) {
      this.amount += amountToPut;
    }
  }

  public boolean take(double amountToTake) {
    //TODO: реализуйте метод и удалите todo
    if (amountToTake < amount && amountToTake > 0) {
      this.amount -= amountToTake;
      return true;
    }
    else return false;
  }

  public boolean send (BankAccount receiver, double amount) {
    if (receiver.take(amount)) {
      return true;
    }
    else return false;
  }
}

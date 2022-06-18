public class LegalPerson extends Client {
    private String conditionPut = "0%";
    private String conditionTake = "1%";

    @Override
    public double getAmount() {
        System.out.println("Комиссия при пополнении: " + conditionPut + "\n" +
                "Комиссия при снятии: "  + conditionTake + "\n" +
                "Баланс: " + deposit);
        return deposit;
    }

    @Override
    public void take(double amountToTake) {
        if (this.deposit >= (amountToTake + (amountToTake * 0.01)) && amountToTake >= 0) {
            this.deposit -= amountToTake + (amountToTake * 0.01);
        }
    }
}

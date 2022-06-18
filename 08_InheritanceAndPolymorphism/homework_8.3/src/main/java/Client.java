public abstract class Client {
    protected Double deposit = 0.0;

    private String conditionPut = "0%";
    private String conditionTake = "0%";


    public double getAmount() {
        System.out.println("Комиссия при пополнении: " + conditionPut + "\n" +
                            "Комиссия при снятии: "  + conditionTake + "\n" +
                            "Баланс: " + deposit);
        return deposit;
    }

    public void put(double amountToPut) {
        if (amountToPut >= 0)
        deposit += amountToPut;
    }

    public void take(double amountToTake) {
        if (deposit >= amountToTake) {
            deposit -= amountToTake;
        }
    }

}

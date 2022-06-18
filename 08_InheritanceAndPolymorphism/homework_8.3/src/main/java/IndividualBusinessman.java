public class IndividualBusinessman extends Client {
    private String conditionPut = "1% при пополнении менее 1000 руб. и 0.5% в иных случаях" ;
    private String conditionTake = "0%";


    @Override
    public double getAmount() {
        System.out.println("Комиссия при пополнении: " + conditionPut + "\n" +
                "Комиссия при снятии: "  + conditionTake + "\n" +
                "Баланс: " + deposit);
        return deposit;
    }

    @Override
    public void put(double amountToPut) {
        if (amountToPut >= 0 ) {
            if (amountToPut >= 1000) {
                this.deposit += amountToPut - (amountToPut * 0.005);
            } else this.deposit += amountToPut - (amountToPut * 0.01);
        }
    }
}

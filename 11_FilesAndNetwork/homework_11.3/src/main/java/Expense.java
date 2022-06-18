public class Expense {
    private final String name;
    private final Double sum;
    public Expense(String name, String sum) {
        this.name = name;
        this.sum = Double.parseDouble(sum.replaceAll("\\D", ""));
    }

    @Override
    public String toString() {
        return name + " " + sum + " руб.";     }
}

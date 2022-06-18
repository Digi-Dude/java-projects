public class Main {

    private static final String pathMovementsCsv = "src/test/resources/movementList.csv";

    public static void main(String[] args) {

        Movements movements = new Movements(pathMovementsCsv);
        System.out.println(movements.getIncomeSum());
        System.out.println(movements.getExpenseSum());
        movements.printAllExpense();

    }
}


public class Main {
    private static String url = "jdbc:mysql://localhost:3306/skillbox";
    private static String user = "root";
    private static String pass = "lHa?0QDojh";

    public static void main(String[] args) {
        AverageValue averageValue = new AverageValue(url, user, pass);
        System.out.println(averageValue.averagePurchasesPerMonth());
    }
}

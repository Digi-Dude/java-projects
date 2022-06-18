import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    System.out.println(calculateSalarySum("Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей"));

  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод

    int sum = 0;

    String[] allSums = text.split("[\\D]");

    for (int i = 0; i < allSums.length; i++) {
      if (!allSums[i].equals("")){
        sum += Integer.parseInt(allSums[i]);
      }
    }
    return sum;
  }

}
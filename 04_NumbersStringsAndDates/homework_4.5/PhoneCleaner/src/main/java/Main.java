import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      StringBuilder currentNumber = new StringBuilder("7");
      String numberPhone = input.replaceAll("[^0-9]", "");
      if (numberPhone.matches("(7|8)\\d{10}"))
      {
        for (int i = 1; i < numberPhone.length(); i++) {
          currentNumber.append(numberPhone.charAt(i));
        }
        System.out.println(currentNumber);
      }
      else if (numberPhone.matches("9\\d{9}")) {
        for (int i = 0; i < numberPhone.length(); i++) {
          currentNumber.append(numberPhone.charAt(i));
        }
        System.out.println(currentNumber);
      }
      else
      {
        System.out.println("Неверный формат номера");
      }

    }
  }

}

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
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

      if(IsValid.isValid(input)) {
        input.trim();
        String[] words = input.split(" ");
        String surname = words[0];
        String name = words[1];
        String patronymic = words[2];
        System.out.println("Фамилия: " + surname + "\n" + "Имя: " + name + "\n" + "Отчество: " + patronymic);
      }
      else  {
        System.out.println("Введенная строка не является ФИО");
      }
    }
  }

}
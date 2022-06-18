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
      input = input.trim();

      if (Valid.isValid(input) == false)
      {
        System.out.println("Введенная строка не является ФИО");
      }
      else
      {
        int firstSpace = input.indexOf(" ");
        int secondSpace = input.lastIndexOf(" ");
        
        String name = input.substring(0, firstSpace);
        String surname = input.substring(firstSpace, secondSpace);
        String patronymic = input.substring(secondSpace, input.length());

        System.out.println("Фамилия: " + name.trim() + "\nИмя: " + surname.trim() + "\nОтчество: " + patronymic.trim());
      }
 
 
    }

  }
}
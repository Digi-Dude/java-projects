import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }



            //TODO: write code here
            String[] command = input.split(" ");
            if (command.length == 2 || command.length == 1) {

                switch (command[0]) {
                    case "ADD": emailList.add(command[1]);
                        break;
                    case "LIST":
                        for (String email: emailList.getSortedEmails()) {
                            System.out.println(email);
                    }
                        break;
                    default: System.out.println("Ввдена неверная команда");
                        break;
                }
            }
            else {
                System.out.println("Ввдена неверная команда");
            }




            
        }
    }
}

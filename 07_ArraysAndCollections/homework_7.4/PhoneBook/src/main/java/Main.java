import java.util.*;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите номер, имя или команду:");
            String command = sc.next();

            if (command.equals("0")) {
                break;
            }


            ///////////////////////////////////////////////////////////////

            if (command.matches("[А-я]+")) {                    // Проверка на формат имени
                String name = new String(command);
                if (phoneBook.getPhonesByName(command).equals(new TreeSet<>())) {
                    System.out.println("Такого имени в телефонной книге нет.\n" +
                             "Введите номер телефона для абонента: " + command);
                    command = sc.next();
                    if (command.matches("\\d{11}")) {              // Проверка на формат имени
                        phoneBook.addContact(command, name);
                    }
                    else System.out.println("Неверный формат ввода");
                }
                else {
                    for (String contact : phoneBook.getPhonesByName(command)) {
                        System.out.println(contact);
                    }
                }
            }

            ///////////////////////////////////////////////////////////////

            else if (command.matches("\\d{11}")) {                   // Проверка ввода на формат телефонного номера
                if (phoneBook.getNameByPhone(command).equals("")) {  // Не найден номер в записной книге
                    String phone = new String(command);
                    System.out.println("Такого номера нет в телефонной книге.\n" +
                             "Введите имя абонента для номера : " + command);
                    command = sc.next();                                // Ввод номера телефона
                    if (command.matches("[А-я]+")) {              // Проверка на формат имени
                        phoneBook.addContact(phone, command);
                    }
                    else System.out.println("Неверный формат ввода");
                }
                else {
                    System.out.println(phoneBook.getNameByPhone(command));  //Вывод найденого контакта
                }
            }

            ///////////////////////////////////////////////////////////////

            else if (command.equals("LIST")) {                               // Проверка на команду LIST
                for (String contact : phoneBook.getAllContacts()) {
                    System.out.println(contact);
                }
            }

            ///////////////////////////////////////////////////////////////

            else System.out.println("Неверный формат ввода");
        }
    }
}

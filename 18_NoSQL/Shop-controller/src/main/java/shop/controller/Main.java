package shop.controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.mongoInit();

        Scanner scanner = new Scanner(System.in);
        do {
            String input = scanner.nextLine();
            String[] command = input.trim().split(" ");

            switch (command[0]) {
                case "ДОБАВИТЬ_МАГАЗИН":
                    manager.addShop(command[1]);
                    break;
                case "ДОБАВИТЬ_ТОВАР":
                    manager.addItem(command[1], Integer.parseInt(command[2]));
                    break;
                case "ВЫСТАВИТЬ_ТОВАР":
                    manager.insertItem(command[1], command[2]);
                    break;
                case "СТАТИСТИКА_ТОВАРОВ":
                    System.out.println(manager.report());
                    break;
                default:
                    System.out.println("Unknown command");
            }

        } while (true);
    }
}

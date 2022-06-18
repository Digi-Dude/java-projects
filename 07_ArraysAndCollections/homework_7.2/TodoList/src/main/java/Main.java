import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if (s.equals("0")) {
                break;
            }
            String[] commands = s.split(" ");
            String todo = "";

            switch(commands[0]){
                case "ADD": if (commands[1].matches("\\d")) {
                                    todo = s.replaceFirst("ADD\\s\\d+", "");
                                    todoList.add(Integer.parseInt(commands[1]), todo.trim());
                             }
                             else {
                                 todo = s.replaceFirst("ADD\\s", "");
                                 todoList.add(todo.trim());
                             }
                             break;
                case "EDIT":  if (commands[1].matches("\\d")) {
                                   todo = s.replaceFirst("EDIT\\s\\d+\\s+", "");
                                    todoList.edit(todo.trim(), Integer.parseInt(commands[1]));
                             }
                             break;
                case "DELETE": if (commands[1].matches("\\d")) {
                                    todoList.delete(Integer.parseInt(commands[1]));
                               }
                               break;
                case "LIST": ArrayList<String> list = todoList.getTodos();
                                    for (int i = 0; i < list.size(); i++) {
                                        System.out.println(i + " - " + list.get(i));
                                    }

                             break;
                default: System.out.println("Введена невеная команда");


            }


//            if (commands[0].equals("ADD")){
//                if (commands[1].matches("\\d")) {
//                    String todo = s.replaceFirst("ADD\\s\\d+", "");
//                    todoList.add(Integer.parseInt(commands[1]), todo);
//
//                }
//                String todo = s.replaceFirst("ADD\\s", "");
//                todoList.add(todo);
//
//            }
//            else if (commands[0].equals("EDIT") && commands[1].matches("\\d")){
//                String todo = s.replaceFirst("EDIT\\s\\d+\\s+", "");
//                todoList.edit(todo, Integer.parseInt(commands[1]));
//            }
//            else if (commands[0].equals("DELETE") && commands[1].matches("\\d")){
//                todoList.delete(Integer.parseInt(commands[1]));
//            }
//            else if (commands[0].equals("LIST")){
//                ArrayList<String> list = todoList.getTodos();
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(i + " - " + list.get(i));
//                }
//            }
//            else {
//                System.out.println("Введена невеная команда");
//            }



        }
    }
}

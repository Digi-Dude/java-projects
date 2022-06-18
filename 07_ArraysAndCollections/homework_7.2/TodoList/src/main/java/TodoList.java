import java.util.ArrayList;

public class TodoList {
    private final ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        this.list.add(todo);
        System.out.println("Добавлено дело " + todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index >= 0 && index < this.list.size()) {
            list.add(index, todo);
            System.out.println("Добавлено дело " + todo);
        }
        else {
            list.add(todo);
            System.out.println("Добавлено дело " + todo);
        }

    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index >= 0 && index < this.list.size()) {
            String editWord = list.get(index);
            list.set(index, todo);
            System.out.println("Дело " + editWord + " заменено на " + list.get(index));
        }
        else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= 0 && index < this.list.size()) {
            String deleteWord = list.get(index);
            list.remove(index);
            System.out.println("Дело " + deleteWord + " удалено");
        }
        else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return list;
    }

}
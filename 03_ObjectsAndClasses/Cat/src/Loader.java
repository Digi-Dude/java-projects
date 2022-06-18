
public class Loader
{


    ////////////////////////////////////////////////////////// Урок 5. Создание объектов и конструктор
    private static Cat getKitten(String name) 
    {
        Cat cat = new Cat(1100.0);
        cat.setName(name);
        return cat;
    }



    public static void main(String[] args)
    {

        ////////////////////////////////////////////////////////// Урок 1. Понятие класса и объекта


        System.out.println(Cat.getCount());
        Cat rich = new Cat();
        System.out.println(Cat.getCount());
        Cat abrikos = new Cat();
        System.out.println(Cat.getCount());
        Cat vasya = new Cat();
        System.out.println(Cat.getCount());
        Cat snickers = new Cat();
        Cat murka = new Cat();
        Cat gosha = new Cat();
        System.out.println(Cat.getCount());


        System.out.println(abrikos.getWeight());
        abrikos.meow();
        System.out.println(abrikos.getWeight());


        System.out.println(rich.getWeight());
        rich.meow();
        System.out.println(rich.getWeight());

        System.out.println(vasya.getWeight());
        vasya.drink(0.5);
        System.out.println(vasya.getWeight());

        System.out.println(snickers.getWeight());
        snickers.feed(1.1);
        System.out.println(snickers.getWeight());

        while (!gosha.getStatus().equals("Exploded")) {
            gosha.feed(75.5);
            System.out.println(gosha.getWeight());
            System.out.println(gosha.getStatus());

        }

        while (!murka.getStatus().equals("Dead")) {
            murka.meow();
            System.out.println(murka.getWeight());
            System.out.println(murka.getStatus());

        }

        ////////////////////////////////////////////////////////// Урок 2. Метод, параметры, return

        System.out.println(rich.howMuchFeed());
        rich.feed(100.0);
        rich.feed(55.0);
        System.out.println(rich.howMuchFeed());

        
        System.out.println(abrikos.getWeight());
        abrikos.pee();
        System.out.println(abrikos.getWeight());
        abrikos.pee();
        System.out.println(abrikos.getWeight());
        murka.pee();
        System.out.println(murka.getWeight());


        ////////////////////////////////////////////////////////// Урок 5. Создание объектов и конструктор
        getKitten("Муся");
        getKitten("Тимофей");
        getKitten("Пират");

        System.out.println(Cat.getCount());    


        ////////////////////////////////////////////////////////// Урок 6. Инкапсуляция, геттеры и сеттеры

        rich.setColor(Color.GRAY);
        System.out.println(rich.getColor());

        ////////////////////////////////////////////////////////// Урок 7. Копирование объектов
        rich.setName("rich");

        Cat barsik  = rich.copyCat(rich);

        // barsik.setName("barsic");

        System.out.println(barsik.getName());
        System.out.println(rich.getName());


    }
}
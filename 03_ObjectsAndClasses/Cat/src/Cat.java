
public class Cat
{
    private static final int EYES_COUNT = 2;
    private double originWeight;
    private double weight;

    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;

    ///////////////////////// Урок 6. Инкапсуляция, геттеры и сеттеры
    private Color color;

    public String name = "";
    private double amountFeed = 0;

    ////////////////////////// Урок 3. Статические методы и переменные
    private static int count = 0; 

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;

    }

    public Cat(double weight)
    {
        this();
        this.weight = weight;
    }

    //////////////// Метод для уствновки имени, чтобы созданные обьекты отличались

    public void setName(String name) {  
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void meow()
    {
        if (weight <= MIN_WEIGHT || weight >= MAX_WEIGHT)
        {
            System.out.println("Кошка не жива, для подобного");

        }
        else
        {
        weight = weight - 1;
        System.out.println("Meow");
        if (weight <= MIN_WEIGHT || weight >= MAX_WEIGHT) {
            count--;
        }
        }
    }

    public void feed(Double amount)
    {
        if (weight <= MIN_WEIGHT || weight >= MAX_WEIGHT) 
        {
            System.out.println("Кошка не жива, для подобного");
            
        }
        else
        {
            weight = weight + amount;
            amountFeed = amountFeed + amount;
            if (weight <= MIN_WEIGHT || weight >= MAX_WEIGHT) {
                count--;
            }
        }

    }

    public void drink(Double amount)
    {
        if (weight <= MIN_WEIGHT || weight >= MAX_WEIGHT)
        {
            
            System.out.println("Кошка не жива, для подобного");
            
        }
        else 
        {
            weight = weight + amount;
            if (weight <= MIN_WEIGHT || weight >= MAX_WEIGHT)
            {
                count--;
            }

        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    
    }

    public void pee() 
    {   
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT) 
        {
            System.out.println("Кошка не жива, для подобного");
        }
        else
        {
            weight = weight - 40;
            System.out.println("Пора почистить лоток");
            if (weight <= MIN_WEIGHT || weight >= MAX_WEIGHT) {
                count--;
            }
        }
        
    }

    public Double howMuchFeed()
    {   
        return amountFeed;
    }


    //////////////////////////// Урок 3. Статические методы и переменные
    public static int getCount()
    {
        return count;
    }


    ///////////////// Урок 6. Инкапсуляция, геттеры и сеттеры
    public void setColor(Color color) 
    {
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }


    ///////////////////////////// Урок 7. Копирование объектов
    public Cat copyCat(Cat cat)         
    {
        Cat newCat = new Cat();
        newCat.name = cat.name;
        newCat.originWeight = cat.originWeight;
        newCat.weight = cat.weight;
        newCat.color = cat.color;
        newCat.amountFeed = cat.amountFeed;
        return newCat;
    }

}
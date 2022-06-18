package core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }

    public void setNumber(String number)
    {
        this.number = number;
    }
    public void setHeight(int height) 
    {
        this.height = height;
    }
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    public void setHasVehicial(String vehical)
    {
        if (vehical == "true") 
        {
            this.hasVehicle = true;
        }
        else 
        {
            this.hasVehicle = false;
        }
    }
    public void setIsSpecial(String special)
    {
        if (special == "special" || special == "Special")
        {
            this.isSpecial = true;
        }
        else
        {
            this.isSpecial = false;
        }
    }


    public String getNumber()
    {
        return number;
    }
    public int getHeight()
    {
        return height;
    }
    public double getWeight()
    {
        return weight;
    }
    public boolean getHasVehicle()
    {
        return hasVehicle;
    }
    public boolean getIsSpecial()
    {
        return isSpecial;
    }
}
package products;

public class Product {
    private final String name;
    private final int count;
    private final double price;
    private final String address;
    private String picture;

    public Product (String name, int count, double price, String address) {
        this.address = address;
        this.count = count;
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String line;
        line = name + " В " + address  + " Количество в магазине " + count + " стоимость: " + price;
        return line;
    }
}


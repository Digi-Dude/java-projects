package products;

public class Shop {

    private final String address;
    private final String id;

    public Shop (String address, String id) {
        this.address = address;
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }


}


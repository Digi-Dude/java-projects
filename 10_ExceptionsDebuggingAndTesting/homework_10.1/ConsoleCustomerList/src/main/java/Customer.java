public class Customer {
    private final String name;
    private final String phone;
    private final String email;

    public String getName() {
        return name;
    }

    public String getPhone() { return phone; }

    public String getEmail() {
        return email;
    }

    public Customer(String name, String phone, String email) {
        if (!name.matches("[А-я]+\\s[А-я]+")
                || !phone.matches("\\+*[7, 8]+\\d{10}")
                || !email.matches("\\S+@\\w+\\.\\w+")) {
            throw new IllegalArgumentException("Wrong format!!!");
        }
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return name + " - " + email + " - " + phone;
    }
}

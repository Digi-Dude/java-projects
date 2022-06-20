import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import products.*;

public class Main {
    private static final Map <String, String> cities = Map.of("Самара", "3", "Новокуйбышевск", "9", "Тольятти", "4", "Чапаевск", "16");

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Введите город \nПримеры:\n Самара, Новокуйбышевск, Тольятти, Чапаевск");
            Scanner sc = new Scanner(System.in);

            String userCity = sc.next();
            if (userCity.equals("0")) {
                break;
            }
            if(!cities.containsKey(userCity)) {
                System.out.println("Введеный не верный город");
                continue;
            }
            System.out.println("Введите ссылку на продукт");
            String urlProduct = sc.next();

            if (urlProduct.equals("0")) {
                break;
            }

            ArrayList<Shop> shops =  Shops.getShops(cities.get(userCity));
            ArrayList<Product> bottles = ProductsList.getProdList(shops, urlProduct);
            for (Product product: bottles) {
                System.out.println(product);
            }

        }
   }

}


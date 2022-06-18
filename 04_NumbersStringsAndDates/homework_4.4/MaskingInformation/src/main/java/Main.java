import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***"));

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений

        if (text.indexOf("<") == -1 || text.indexOf(">") == -1) {
            return text;
        }

        if (text.indexOf("<") == text.lastIndexOf("<")) {

            String diamonds = text.substring(text.indexOf("<"), text.indexOf(">") + 1);
            text = text.replace(diamonds, placeholder);
        }
        else {
            String diamonds = text.substring(text.indexOf("<"), text.indexOf(">") + 1);
            String secondDiamond = text.substring(text.lastIndexOf("<"), text.lastIndexOf(">") + 1);
            text = text.replace(diamonds, placeholder);
            text = text.replace(secondDiamond, placeholder);
        }

        return text;
    }



}
public class Main {

    public static void main(String[] args) {

        System.out.println(searchAndReplaceDiamonds("Пин код <6160>", "***"));

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        text = text.replaceAll("(<(\\d+(\\s*\\d*)*)>)+", placeholder);
        return text;
    }

}
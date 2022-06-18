public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] lle = line.split(",?\\s+");
        for (String word : ReverseArray.reverse(lle)) {
            System.out.println(word);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        char[][] matrix = TwoDimensionalArray.getTwoDimensionalArray(1);
        for (char[] mar: matrix ) {
            System.out.println(mar);
        }

    }
}

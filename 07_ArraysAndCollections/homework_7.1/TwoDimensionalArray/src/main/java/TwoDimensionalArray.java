public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] matrix = new char[size][size];
        int middleLine = (int)Math.round(matrix.length / 2.0);



        for (int i = 0; i < middleLine ; i++) {

            for (int c = 0; c < matrix.length; c++) {
                matrix[i][c] = ' ';
                matrix[matrix.length - 1 - i][c] = ' ';
            }

            matrix[i][i] = symbol;
            matrix[i][matrix.length - 1 - i] = symbol;
            matrix[matrix.length - 1 - i][i] = symbol;
            matrix[matrix.length - 1 - i][matrix.length -1 - i] = symbol;
        }


        return matrix;
    }
}

import java.util.HashSet;

public class App {
    public static void setZeroes(int[][] matrix) {
        boolean firstColumn = false, firstRow = false;
        for (int row = 0; row < matrix.length; row++)
            for (int column = 0; column < matrix[0].length; column++)
                if (matrix[row][column] == 0) {
                    matrix[0][column] = 0;
                    matrix[row][0] = 0;
                    if (row == 0)
                        firstRow = true;
                    if (column == 0)
                        firstColumn = true;
                }
        for (int row = 1; row < matrix.length; row++)
            for (int column = 1; column < matrix[0].length; column++)
                if (matrix[0][column] == 0 || matrix[row][0] == 0)
                    matrix[row][column] = 0;
        if (firstRow)
            for (int index = 0; index < matrix[0].length; index++)
                matrix[0][index] = 0;
        if (firstColumn)
            for (int index = 0; index < matrix.length; index++)
                matrix[index][0] = 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 3 }
        };
        setZeroes(matrix);
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++)
                System.out.print(matrix[row][column]);
            System.out.println();
        }
    }
}

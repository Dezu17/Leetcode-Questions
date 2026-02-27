import java.util.ArrayList;
import java.util.List;

public class App {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int row = 0, column = 0;
        while (top <= bottom && left <= right) {
            row = top;
            for (column = left; column <= right; column++)
                result.add(matrix[row][column]);
            top++;
            column = right;
            for (row = top; row <= bottom; row++)
                result.add(matrix[row][column]);
            right--;
            row = bottom;
            if (top <= bottom) {
                for (column = right; column >= left; column--)
                    result.add(matrix[row][column]);
                bottom--;
            }
            column = left;
            if (left <= right) {
                for (row = bottom; row >= top; row--)
                    result.add(matrix[row][column]);
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1 }, { 2 } };
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }
}
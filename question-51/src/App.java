import java.util.ArrayList;
import java.util.List;

public class App {

    private static List<List<String>> result;

    private static boolean checkValid(char[][] board, int[] columns, int[] rightDiagonal, int[] leftDiagonal, int row) {
        for (int column = 0; column < board.length; column++)
            if (board[row][column] == 'Q') {
                if (columns[column] == 1)
                    return false;
                if (rightDiagonal[row + column] == 1)
                    return false;
                if (leftDiagonal[board.length - 1 + row - column] == 1)
                    return false;
            }
        return true;
    }

    private static void addSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            String currentRow = "";
            for (int column = 0; column < board.length; column++)
                currentRow += board[row][column];
            solution.add(currentRow);
        }
        result.add(solution);
    }

    private static void generateSolutions(char[][] board, int[] columns, int[] rightDiagonal, int[] leftDiagonal,
            int row) {
        if (row < board.length)
            for (int index = 0; index < board.length; index++) {
                for (int column = 0; column < board.length; column++)
                    if (column == index)
                        board[row][column] = 'Q';
                    else
                        board[row][column] = '.';
                if (checkValid(board, columns, rightDiagonal, leftDiagonal, row)) {
                    columns[index] = 1;
                    rightDiagonal[row + index] = 1;
                    leftDiagonal[board.length - 1 + row - index] = 1;
                    generateSolutions(board, columns, rightDiagonal, leftDiagonal, row + 1);
                    columns[index] = 0;
                    rightDiagonal[row + index] = 0;
                    leftDiagonal[board.length - 1 + row - index] = 0;
                }
            }
        else
            addSolution(board);
    }

    public static List<List<String>> solveNQueens(int n) {
        int[] columns = new int[n];
        int[] rightDiagonal = new int[n * 2];
        int[] leftDiagonal = new int[n * 2];
        char[][] board = new char[n][n];
        result = new ArrayList<>();
        generateSolutions(board, columns, rightDiagonal, leftDiagonal, 0);
        return result;

    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> results = solveNQueens(n);
        for (int index = 0; index < results.size(); index++)
            System.out.println(results.get(index));
    }
}

import java.util.Arrays;

public class App {
    private void dfs(char[][] board, int row, int column) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != 'O')
            return;
        board[row][column] = '-';
        int[][] coordinates = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int index = 0; index < coordinates.length; index++)
            dfs(board, row + coordinates[index][0], column + coordinates[index][1]);
    }

    public void solve(char[][] board) {
        for (int index = 0; index < board.length; index++) {
            dfs(board, index, 0);
            dfs(board, index, board[0].length - 1);
        }
        for (int index = 0; index < board[0].length; index++) {
            dfs(board, 0, index);
            dfs(board, board.length - 1, index);
        }
        for (int row = 0; row < board.length; row++)
            for (int column = 0; column < board[0].length; column++)
            if (board[row][column] == '-')
                board[row][column] = 'O';
            else if (board[row][column] == 'O')
                board[row][column] = 'X';
    }
    
    private static void testSolve(char[][] board, char[][] expected) {
        new App().solve(board);
        if (!Arrays.deepEquals(board, expected))
            throw new AssertionError("Expected " + Arrays.deepToString(expected)
                    + " but got " + Arrays.deepToString(board));
        System.out.println("Passed: " + Arrays.deepToString(board));
    }

    public static void main(String[] args) throws Exception {
        testSolve(
                new char[][] {
                    {'X', 'X', 'X', 'X'},
                    {'X', 'O', 'O', 'X'},
                    {'X', 'X', 'O', 'X'},
                    {'X', 'O', 'X', 'X'}
                },
                new char[][] {
                    {'X', 'X', 'X', 'X'},
                    {'X', 'X', 'X', 'X'},
                    {'X', 'X', 'X', 'X'},
                    {'X', 'O', 'X', 'X'}
                });
        testSolve(
                new char[][] {{'X'}},
                new char[][] {{'X'}});
        testSolve(
                new char[][] {
                    {'X', 'X', 'X', 'X', 'O'},
                    {'X', 'O', 'O', 'X', 'X'},
                    {'O', 'X', 'X', 'X', 'X'}
                },
                new char[][] {
                    {'X', 'X', 'X', 'X', 'O'},
                    {'X', 'X', 'X', 'X', 'X'},
                    {'O', 'X', 'X', 'X', 'X'}
                });
    }
}

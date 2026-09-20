public class App {
    private boolean backtrack(char[][] board, String word, int index, int row, int column) {	
        if (index == word.length())
            return true;
        if (row >= 0 && row < board.length && column >= 0 && column < board[0].length)
            if (board[row][column] == word.charAt(index)) {
                board[row][column] = '0';
                boolean result = backtrack(board, word, index + 1, row + 1, column) || 
                                 backtrack(board, word, index + 1, row - 1, column) || 
                                 backtrack(board, word, index + 1, row, column + 1) || 
                                 backtrack(board, word, index + 1, row, column - 1);
                board[row][column] = word.charAt(index);
                return result;
            }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++)
            for (int column = 0; column < board[0].length; column++)
                if (backtrack(board, word, 0, row, column))   
                    return true;
        return false;     
    }
    public static void main(String[] args) throws Exception {
        App app = new App();

        System.out.println(app.exist(new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        }, "ABCCED"));

        System.out.println(app.exist(new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        }, "SEE"));

        System.out.println(app.exist(new char[][] {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' }
        }, "ABCB"));

        System.out.println(app.exist(new char[][] {
            { 'A', 'B', 'C', 'D' },
            { 'S', 'A', 'A', 'T' },
            { 'A', 'C', 'A', 'E' }
        }, "CAT"));

        System.out.println(app.exist(new char[][] {
            { 'A', 'B', 'C', 'D' },
            { 'S', 'A', 'A', 'T' },
            { 'A', 'C', 'A', 'E' }
        }, "BAT"));
    }
}

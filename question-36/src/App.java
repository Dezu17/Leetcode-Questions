import java.util.HashMap;
import java.util.HashSet;

public class App {
    private static boolean isDigit(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        return false;
    }
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> columns = new HashMap<>();
        HashMap<Integer, HashSet<Character>> boxes = new HashMap<>();
        for (int row = 0; row < board.length; row++)
            for (int column = 0; column < board[0].length; column++)
                if (isDigit(board[row][column])) {
                    HashSet<Character> currentSet;
                    if (!rows.containsKey(row))
                        currentSet = new HashSet<>();
                    else
                        currentSet = rows.get(row);
                    if (currentSet.contains(board[row][column]))
                        return false;
                    currentSet.add(board[row][column]);
                    rows.put(row, currentSet);
                    if (!columns.containsKey(column))
                        currentSet = new HashSet<>();
                    else
                        currentSet = columns.get(column);
                    if (currentSet.contains(board[row][column]))
                        return false;
                    currentSet.add(board[row][column]);
                    columns.put(column, currentSet);
                    int box = row / 3 * 3 + column / 3;
                    if (!boxes.containsKey(box))
                        currentSet = new HashSet<>();
                    else
                        currentSet = boxes.get(box);
                    if (currentSet.contains(board[row][column]))
                        return false;
                    currentSet.add(board[row][column]);
                    boxes.put(box, currentSet);
                }
        return true;
    }
    public static void main(String[] args) throws Exception {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
}

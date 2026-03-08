public class Program
{
    public static bool IsValidSudoku(char[][] board)
    {
        HashSet<char>[] rows = new HashSet<char>[9];
        HashSet<char>[] columns = new HashSet<char>[9];
        HashSet<char>[] sections = new HashSet<char>[9];
        for (int index = 0; index < 9; index++)
        {
            rows[index] = new HashSet<char>();
            columns[index] = new HashSet<char>();
            sections[index] = new HashSet<char>();
        }
        for (int row = 0; row < 9; row++)
            for (int column = 0; column < 9; column++)
            {
                if (board[row][column] != '.')
                {
                    if (rows[row].Contains(board[row][column]))
                        return false;
                    else
                        rows[row].Add(board[row][column]);
                    if (columns[column].Contains(board[row][column]))
                        return false;
                    else
                        columns[column].Add(board[row][column]);
                    int offset = (row / 3) * 3 + column / 3;
                    if (sections[offset].Contains(board[row][column]))
                        return false;
                    else
                        sections[offset].Add(board[row][column]);
                }
            }
        return true;
    }
    public static void Main(string[] args)
    {
        char[][] board = new []{ new[] { '8', '3', '.', '.', '7', '.', '.', '.', '.' }
, new[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' }
, new[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
new[]{'8','.','.','.','6','.','.','.','3'}
,new []{'4','.','.','8','.','3','.','.','1'}
,new []{'7','.','.','.','2','.','.','.','6'}
,new []{'.','6','.','.','.','.','2','8','.'}
,new []{'.','.','.','4','1','9','.','.','5'}
,new []{'.','.','.','.','8','.','.','7','9'}};
        Console.WriteLine(IsValidSudoku(board));
    }
}
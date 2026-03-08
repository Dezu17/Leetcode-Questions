public class Program
{
    public static string Convert(string s, int numRows)
    {
        if (numRows == 1)
            return s;
        string[] rows = new string[numRows];
        Boolean isIncreasing = true;
        int currentRow = 1;
        rows[0] += s[0];
        for (int index = 1; index < s.Length; index++)
        {
            rows[currentRow] += s[index];
            if (currentRow == 0 || currentRow == numRows - 1)
                isIncreasing = !isIncreasing;
            if (isIncreasing)
                currentRow++;
            else
                currentRow--;
        }
        string result = "";
        for (int index = 0; index < rows.Length; index++)
            result += rows[index];
        return result;
    }
    public static void Main(string[] args)
    {
        string s = "PAYPALISHIRING";
        int k = 1;
        Console.WriteLine(Convert(s, k));
    }
}
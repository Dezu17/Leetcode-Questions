public class Program
{
    public static IList<IList<int>> Generate(int numRows) {
        if (numRows == 1)
            return new List<IList<int>> { new List<int> {1} };
        else if (numRows == 2)
            return new List<IList<int>> { new List<int> {1}, new List<int> {1, 1} };
        else
        {
            IList<IList<int>> result = new List<IList<int>>();
            result.Add(new List<int> {1});
            result.Add(new List<int> {1, 1});
            for (int count = 3; count <= numRows; count++)
            {
                List<int> currentRow = new List<int>();
                List<int> previousRow = (List<int>)result[count - 2];
                for (int index = 0; index < count; index++)
                    if (index == 0 || index == count - 1)
                        currentRow.Add(1);
                    else
                        currentRow.Add(previousRow[index - 1] + previousRow[index]);
                result.Add(currentRow);
            }
            return result;
        }
    }
    public static void Main(string[] args)
    {
        int numRows = 1;
        IList<IList<int>> result = Generate(numRows);
        for (int i = 0; i < result.Count; i++)
        {
            for (int j = 0; j < result[i].Count; j++)
            {
                Console.Write(result[i][j] + " ");
            }
            Console.WriteLine();
        }
    }
}
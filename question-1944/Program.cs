public class Program
{
    public static int[] CanSeePersonsCount(int[] heights)
    {
        int[] result = new int[heights.Length];
        result[heights.Length - 1] = 0;
        Stack<int> visiblePeople = new Stack<int>();
        visiblePeople.Push(heights[heights.Length - 1]);
        for (int index = heights.Length - 2; index >= 0; index--)
        {
            int count = 0;
            while (visiblePeople.Count != 0 && heights[index] > visiblePeople.Peek())
            {
                count++;
                visiblePeople.Pop();
            }
            if (visiblePeople.Count != 0)
                count++;
            visiblePeople.Push(heights[index]);
            result[index] = count;
        }
        return result;
    }
    public static void Main(string[] args)
    {
        int[] heights = { 10, 6, 8, 5, 11, 9 };
        int[] result = CanSeePersonsCount(heights);
        for (int index = 0; index < result.Length; index++)
            Console.Write(result[index] + " ");
    }
}
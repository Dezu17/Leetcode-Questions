public class Program
{
    public static int CountTrapezoids(int[][] points)
    {
        Dictionary<int, int> frequencies = new Dictionary<int, int>();
        for (int point = 0; point < points.Length; point++)
            if (frequencies.ContainsKey(points[point][1]))
                frequencies[points[point][1]]++;
            else
                frequencies.Add(points[point][1], 1);
        int result = 0;
        int totalPoints = 0;
        foreach (var current in frequencies)
        {
            int lines = current.Value * (current.Value - 1) / 2;
            result += totalPoints * lines;
            totalPoints += current.Value * (current.Value - 1) / 2;
        }
        return result;
    }
    public static void Main(string[] args)
    {
        int[][] points = new int[][] {
            new int[] { 0, 0 },
            new int[] { 1, 0 },
            new int[] { 0, 1 },
            new int[] { 2, 1 },
        };
        Console.WriteLine(CountTrapezoids(points));
    }
}
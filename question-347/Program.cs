using System.Collections;

public class Program
{
    public static int[] TopKFrequent(int[] nums, int k) {
        Hashtable frequency = new Hashtable();
        for (int index = 0; index < nums.Length; index++)
            if (!frequency.Contains(nums[index]))
                frequency.Add(nums[index], 1);
            else {
                int count = (int)frequency[nums[index]];
                frequency[nums[index]] = ++count;
            }
        PriorityQueue<int, int> orderedElements = new PriorityQueue<int, int>();
        foreach (DictionaryEntry current in frequency)
            orderedElements.Enqueue((int)current.Key, (int)current.Value * -1);
        int[] result = new int[k];
        for (int count = 0; count < k; count++)
            result[count] = orderedElements.Dequeue();
        return result;
    }
    public static void Main(String[] args)
    {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        int[] result = TopKFrequent(nums, k);
        for (int index = 0; index < result.Length; index++)
            Console.Write(result[index] + " ");
    }
}
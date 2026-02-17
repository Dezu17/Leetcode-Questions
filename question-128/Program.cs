using System.Collections;

public class Program
{
    public static int LongestConsecutive(int[] nums) {
        Hashtable numbers = new Hashtable();
        int maxLength = 0;
        for (int index = 0; index < nums.Length; index++)
        {
            if (!numbers.Contains(nums[index]))
                numbers.Add(nums[index], 1);
        }
        for (int index = 0; index < nums.Length; index++) {
            if (numbers.Contains(nums[index]) && !numbers.Contains(nums[index] - 1)) {
                int currentLength = 1;
                int next = nums[index] + 1;
                numbers.Remove(nums[index]);
                while (numbers.Contains(next)) {
                    currentLength++;
                    numbers.Remove(next);
                    next++;
                }
                if (currentLength > maxLength)
                    maxLength = currentLength;
            }
        }
        return maxLength;
    }
    public static void Main(String[] args)
    {
        int[] nums = {100,4,200,1,3,2};
        Console.WriteLine(LongestConsecutive(nums));
    }
}
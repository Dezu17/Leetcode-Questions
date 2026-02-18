public class Program
{
    public static int SubarraySum(int[] nums, int k)
    {
        Dictionary<int, int> frequencies = new Dictionary<int, int>();
        int prefixSum = 0, result = 0;
        for (int index = 0; index < nums.Length; index++)
        {
            prefixSum += nums[index];
            if (prefixSum == k)
                result++;
            if (frequencies.ContainsKey(prefixSum - k))
                result += frequencies[prefixSum - k];
            if (!frequencies.ContainsKey(prefixSum))
                frequencies.Add(prefixSum, 0);
            frequencies[prefixSum]++;
        }
        return result;
    }
    public static void Main(string[] args)
    {
        int[] nums = { 1, 1, 1 };
        int k = 2;
        Console.WriteLine(SubarraySum(nums, k));
    }
}
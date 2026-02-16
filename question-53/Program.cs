class Program
{
    public static int MaxSubArray(int[] nums) {
        int maxSum = nums[0], currentSum = nums[0];
        for (int index = 1; index < nums.Length; index++)
        {
            if (currentSum + nums[index] > nums[index])
                currentSum += nums[index];
            else
                currentSum = nums[index];
            if (currentSum > maxSum)
                maxSum = currentSum;
        }
        return maxSum;
    }
    static void Main(string[] args)
    {
        int[] nums = new int[] { 5, 4, -1, 7, 8 };
        Console.WriteLine(MaxSubArray(nums));
    }
}

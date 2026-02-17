using System.Collections;

public class Program
{
    public static int MajorityElement(int[] nums) {
        int potential = nums[0], count = 1;
        for (int index = 1; index <nums.Length; index++) {
            if (potential == nums[index])
                count++;
            else if (count == 0)
            {
                potential = nums[index];
                count++;
            }
            else
                count--;
        }
        count = 0;
        for (int index = 0; index < nums.Length; index++)
            if (nums[index] == potential)
                count++;
        return potential;
    }
    public static void Main(String[] args)
    {
        int[] nums = {2,2,1,1,1,2,2};
        Console.WriteLine(MajorityElement(nums));
    }
}
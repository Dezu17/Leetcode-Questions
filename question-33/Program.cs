public class Program
{
    public static int FindPivot(int[] nums)
    {
        int left = 0, right = nums.Length - 1;
        while (left <= right)
        {
            if (nums[left] <= nums[right])
                return left;
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    public static int Search(int[] nums, int target) {
        int pivot = FindPivot(nums);
        int left = 0, right = nums.Length - 1;
        if (target == nums[pivot])
            return pivot;
        else if (target > nums[pivot] && target <= nums[right])
            left = pivot + 1;
        else
            right = pivot - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    public static void Main(string[] args)
    {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 6;
        Console.WriteLine(Search(nums, target));
    }
}
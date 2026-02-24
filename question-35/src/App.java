public class App {
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (nums[left] < target)
            return left + 1;
        else
            return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 7;
        System.out.println("Index: " + searchInsert(nums, target));
    }
}

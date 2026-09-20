public class App {
    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid])
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target)
            return 0;
        else if (nums.length == 1)
            return -1;
        if (nums[0] <= nums[nums.length - 1])
            return binarySearch(nums, target, 0, nums.length - 1);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        if (nums[0] <= target && target <= nums[right - 1])
            return binarySearch(nums, target, 0, right - 1);
        else
            return binarySearch(nums, target, right, nums.length - 1);
    }
    public static void main(String[] args) throws Exception {
        testSearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 0, 4);
        testSearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 3, -1);
        testSearch(new int[] {5, 1, 3}, 5, 0);
        testSearch(new int[] {6, 7, 1, 2, 3, 4, 5}, 7, 1);
        testSearch(new int[] {1}, 1, 0);
        testSearch(new int[] {1}, 0, -1);
    }

    private static void testSearch(int[] nums, int target, int expected) {
        int actual = new App().search(nums, target);
        if (actual != expected) {
            throw new AssertionError("Expected index " + expected + " but got " + actual);
        }
        System.out.println("Passed: target " + target + " -> index " + actual);
    }
}

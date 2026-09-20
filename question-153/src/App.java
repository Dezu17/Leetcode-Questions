public class App {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
    public static void main(String[] args) throws Exception {
        testFindMin(new int[] {3, 4, 5, 1, 2}, 1);
        testFindMin(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
        testFindMin(new int[] {11, 13, 15, 17}, 11);
        testFindMin(new int[] {2, 1}, 1);
        testFindMin(new int[] {1}, 1);
    }

    private static void testFindMin(int[] nums, int expected) {
        int actual = new App().findMin(nums);
        if (actual != expected) {
            throw new AssertionError("Expected minimum " + expected + " but got " + actual);
        }
        System.out.println("Passed: minimum = " + actual);
    }
}

public class App {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }	
        return -1;        
    }
    public static void main(String[] args) throws Exception {
        testSearch(new int[] {-1, 0, 3, 5, 9, 12}, 9, 4);
        testSearch(new int[] {-1, 0, 3, 5, 9, 12}, 2, -1);
        testSearch(new int[] {5}, 5, 0);
        testSearch(new int[] {5}, 1, -1);
        testSearch(new int[] {}, 3, -1);
    }

    private static void testSearch(int[] nums, int target, int expected) {
        int actual = new App().search(nums, target);
        if (actual != expected) {
            throw new AssertionError("Expected index " + expected + " but got " + actual);
        }
        System.out.println("Passed: target " + target + " -> index " + actual);
    }
}

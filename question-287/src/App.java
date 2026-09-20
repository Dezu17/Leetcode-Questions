public class App {
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
        }while (slow != fast);
        return slow;
    }
    public static void main(String[] args) throws Exception {
        testFindDuplicate(new int[] {1, 3, 4, 2, 2}, 2);
        testFindDuplicate(new int[] {3, 1, 3, 4, 2}, 3);
        testFindDuplicate(new int[] {1, 2, 3, 2, 2}, 2);
    }

    private static void testFindDuplicate(int[] nums, int expected) {
        int actual = findDuplicate(nums);
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
        System.out.println("Passed: duplicate = " + actual);
    }
}

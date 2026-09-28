import java.util.Map;
import java.util.HashMap;

public class App {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int count = 0, sum = 0;
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            if (sum == k)
                count++;
            if (frequencies.containsKey(sum - k))
                count += frequencies.get(sum - k);
            frequencies.put(sum, (frequencies.containsKey(sum) ? frequencies.get(sum) : 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        testSubarraySum(new int[] {2, -1, 1, 2}, 2, 4);
        testSubarraySum(new int[] {4, 4, 4, 4, 4, 4}, 4, 6);
        testSubarraySum(new int[] {1, 1, 1}, 2, 2);
        testSubarraySum(new int[] {1, 2, 3}, 3, 2);
        testSubarraySum(new int[] {1}, 3, 0);
        testSubarraySum(new int[] {}, 3, 0);
    }

    private static void testSubarraySum(int[] nums, int k, int expected) {
        int actual = new App().subarraySum(nums, k);
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
        System.out.println("Passed: subarray count = " + actual);
    }
}

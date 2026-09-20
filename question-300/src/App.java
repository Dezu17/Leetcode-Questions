import java.util.Arrays;

public class App {
    public int lengthOfLIS(int[] nums) {
        int maxLength = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int currentElement = 0; currentElement < dp.length; currentElement++)
            for (int previousElement = 0; previousElement < currentElement; previousElement++) {
                if (nums[currentElement] > nums[previousElement]) {
                    dp[currentElement] = Math.max(dp[currentElement], dp[previousElement] + 1);
                    maxLength = Math.max(maxLength, dp[currentElement]);
                }
            }
        return maxLength;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] tests = {
            {10, 9, 2, 5, 3, 7, 101, 18},
            {0, 1, 0, 3, 2, 3},
            {7, 7, 7, 7, 7, 7, 7},
            {7},
            {9, 1, 4, 2, 3, 3, 7}
        };

        for (int[] nums : tests) {
            System.out.println(app.lengthOfLIS(nums));
        }
    }
}

public class App {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > nums[index] + sum)
                sum = nums[index];
            else
                sum += nums[index];
            if (maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] tests = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4},
            {1},
            {5, 4, -1, 7, 8},
            {2, -3, 4, -2, 2, 1, -1, 4},
            {-2}
        };

        for (int[] nums : tests) {
            System.out.println(app.maxSubArray(nums));
        }
    }
}

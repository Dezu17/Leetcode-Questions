public class App {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = -1, sum = 0, start = 0, end = 0;
        while (end < nums.length) {
            while (end < nums.length && sum < target)
                sum += nums[end++];
            if (end >= nums.length && sum < target)
                break;
            while (sum >= target) {
                if (minLength == -1 || minLength > end - start)
                    minLength = end - start;
                sum -= nums[start++];
            }
            sum -= nums[start++];
        }
        return minLength == -1 ? 0 : minLength;
    }
    
    public static void main(String[] args) throws Exception {
        App solution = new App();

        System.out.println(solution.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
        System.out.println(solution.minSubArrayLen(4, new int[] { 1, 4, 4 }));
        System.out.println(solution.minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 }));
    }
}

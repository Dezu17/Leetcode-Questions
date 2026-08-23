public class App {
    public static int[] getConcatenation(int[] nums) {
        int result[] = new int[2 * nums.length];
        for (int index = 0; index < nums.length; index++) {
            result[index] = nums[index];
            result[index + nums.length] = nums[index];
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        int[] nums = {1, 2, 3};
        int[] results = getConcatenation(nums);
        for (int index = 0; index < results.length; index++)
            System.out.print(results[index] + " ");
    }
}
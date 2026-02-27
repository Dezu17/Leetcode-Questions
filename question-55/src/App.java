public class App {
    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int index = 0; index < nums.length; index++) {
            if (max < index)
                return false;
            else {
                if (max < index + nums[index])
                    max = nums[index] + index;
            }
            if (max > nums.length - 1)
                return true;
        }
        if (max > nums.length - 2)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 0 };
        System.out.println(canJump(nums));
    }
}

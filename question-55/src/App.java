public class App {
    public boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;
        for (int index = nums.length - 2; index >= 0; index--)
            if (lastPosition <= index + nums[index])
                lastPosition = index;
        return lastPosition == 0 ? true : false;
    }

    public static void main(String[] args) {
        App app = new App();

        int[][] tests = {
            {2, 3, 1, 1, 4},
            {3, 2, 1, 0, 4},
            {1, 2, 0, 1, 0},
            {1, 2, 1, 0, 1}
        };

        for (int[] nums : tests) {
            System.out.println(app.canJump(nums));
        }
    }
}

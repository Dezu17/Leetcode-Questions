public class App {
    public int jump(int[] nums) {
        int count = 0, maxJump = 0, currentJump = 0;
        for (int index = 0; index < nums.length; index++) {
            maxJump = Math.max(maxJump, nums[index] + index);
            if (maxJump >= nums.length - 1)
                return count + 1;
            if (index == currentJump) {
                if (index == maxJump)
                    return -1;
                else {
                count++;
                    currentJump = maxJump;
            }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] tests = {
            {2, 3, 1, 1, 4},
            {2, 3, 0, 1, 4},
            {2, 3, 1, 1, 1, 1},
            {2, 1, 2, 1, 0}
        };

        for (int[] nums : tests) {
            System.out.println(app.jump(nums));
        }
    }
}
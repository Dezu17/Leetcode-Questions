public class App {
    public static int removeElement(int[] nums, int val) {
        int current = 0, next = 0;
        while (next < nums.length)
            if (nums[next] == val)
                next++;
            else
                nums[current++] = nums[next++];
        return current;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        System.out.print(removeElement(nums, val));
    }
}

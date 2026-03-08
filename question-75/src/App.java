public class App {
    public static void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                nums[mid] = nums[left];
                nums[left] = 0;
                left++;
                mid++;
            } else if (nums[mid] == 2) {
                nums[mid] = nums[right];
                nums[right] = 2;
                right--;
            } else
                mid++;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        for (int index = 0; index < nums.length; index++)
            System.out.printf("%d ", nums[index]);
    }
}

public class App {
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
            int aux = nums[left];
            nums[left] = nums[right];
            nums[right] = aux;
        }
        for (int left = 0, right = k - 1; left < right; left++, right--) {
            int aux = nums[left];
            nums[left] = nums[right];
            nums[right] = aux;
        }
        for (int left = k, right = nums.length - 1; left < right; left++, right--) {
            int aux = nums[left];
            nums[left] = nums[right];
            nums[right] = aux;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 6;
        rotate(nums, k);
        for (int index = 0; index < nums.length; index++)
            System.out.print(nums[index] + " ");
    }
}

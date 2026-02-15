import java.util.Arrays;

public class App {
    public static void nextPermutation(int[] nums) {
        int pivot = -1, index = 0;
        for (index = 1; index < nums.length; index++) {
            if (nums[index - 1] < nums[index])
                pivot = index - 1;
        }
        if (pivot == -1) {
            for (index = 0; index < nums.length / 2; index++) {
                nums[index] += nums[nums.length - index - 1];
                nums[nums.length - index - 1] = nums[index] - nums[nums.length - index - 1];
                nums[index] -= nums[nums.length - index - 1];
            }
        } else {
            int greater = -1;
            index = pivot + 1;
            while (index < nums.length) {
                if (nums[index] > nums[pivot])
                    greater = index;
                index++;
            }
            nums[pivot] += nums[greater];
            nums[greater] = nums[pivot] - nums[greater];
            nums[pivot] -= nums[greater];
            for (index = pivot + 1; index < (nums.length + pivot + 1) / 2; index++) {
                nums[index] += nums[nums.length - index + pivot];
                nums[nums.length - index + pivot] = nums[index] - nums[nums.length - index + pivot];
                nums[index] -= nums[nums.length - index + pivot];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1 };
        nextPermutation(nums);
        System.out.print("Result " + Arrays.toString(nums));
    }
}
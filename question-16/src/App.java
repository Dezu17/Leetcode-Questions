public class App {

    private static void sort(int[] nums) {
        for (int index1 = 0; index1 < nums.length; index1++)
            for (int index2 = index1 + 1; index2 < nums.length; index2++)
                if (nums[index1] > nums[index2]) {
                    int aux = nums[index1];
                    nums[index1] = nums[index2];
                    nums[index2] = aux;
                }
    }

    public static int threeSumClosest(int[] nums, int target) {
        sort(nums);
        int closestSum = Integer.MAX_VALUE, closestDifference = Integer.MAX_VALUE;
        for (int index = 0; index < nums.length; index++) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[index] + nums[left] + nums[right];
                // System.out.println("Current numbers: " + nums[index] + " " + nums[left] + " "
                // + nums[right]);
                if (left != index && right != index && currentSum == target)
                    return target;
                int currentDifference = Math.abs(target - currentSum);
                if (left != index && right != index && currentDifference < closestDifference) {
                    closestSum = currentSum;
                    closestDifference = currentDifference;
                }
                if (currentSum < target)
                    left++;
                else
                    right--;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        System.out.print("Result: " + threeSumClosest(nums, target));
    }
}

public class App {
    public static int removeDuplicates(int[] nums) {
        int currentIndex = 0, nextUniqueIndex = 1;
        while (nextUniqueIndex < nums.length) {
            if (nums[currentIndex] != nums[nextUniqueIndex]) {
                nums[++currentIndex] = nums[nextUniqueIndex];
            }
            nextUniqueIndex++;
        }
        return currentIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1 };
        int newLength = removeDuplicates(nums);
        System.out.print("Result: " + newLength);
    }
}

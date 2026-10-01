import java.util.Arrays;

public class App {
    public void rotate(int[] nums, int k) {
        int count = 0;
        for (int startIndex = 0; startIndex < k && count < nums.length; startIndex++) {
            int elementToMove = nums[startIndex];
            int index = (startIndex + k) % nums.length;
            while (count < nums.length && index != startIndex) {
                int aux = nums[index];
                nums[index] = elementToMove;
                elementToMove = aux;
                count++;
                index = (index + k) % nums.length;
            }
            nums[startIndex] = elementToMove;
            count++;
        }
    }

    private static void testRotate(int[] nums, int k, int[] expected) {
        new App().rotate(nums, k);
        if (!Arrays.equals(nums, expected))
            throw new AssertionError("Expected " + Arrays.toString(expected)
                    + " but got " + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        testRotate(
                new int[] {1, 2, 3, 4, 5, 6, 7, 8},
                4,
                new int[] {5, 6, 7, 8, 1, 2, 3, 4});
        testRotate(
                new int[] {1000, 2, 4, -3},
                2,
                new int[] {4, -3, 1000, 2});
        testRotate(
                new int[] {1, 2, 3, 4, 5, 6, 7},
                3,
                new int[] {5, 6, 7, 1, 2, 3, 4});
        testRotate(
                new int[] {-1, -100, 3, 99},
                2,
                new int[] {3, 99, -1, -100});
    }
}

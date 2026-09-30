import java.util.*;

public class App {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0)
            if (nums1[m] > nums2[n])
                nums1[index--] = nums1[m--];
            else
                nums1[index--] = nums2[n--];
        while (n >= 0)
            nums1[index--] = nums2[n--];
    }
    public static void main(String[] args) throws Exception {
        App solution = new App();
        int[][] nums1Inputs = {
                { 10, 20, 20, 40, 0, 0 },
                { 0, 0 }
        };
        int[] mInputs = { 4, 0 };
        int[][] nums2Inputs = {
                { 1, 2 },
                { 1, 2 }
        };
        int[] nInputs = { 2, 2 };
        int[][] expected = {
                { 1, 2, 10, 20, 20, 40 },
                { 1, 2 }
        };

        for (int index = 0; index < nums1Inputs.length; index++) {
            solution.merge(nums1Inputs[index], mInputs[index], nums2Inputs[index], nInputs[index]);
            System.out.printf(
                    "expected: %s | actual: %s | %s%n",
                    Arrays.toString(expected[index]),
                    Arrays.toString(nums1Inputs[index]),
                    Arrays.equals(nums1Inputs[index], expected[index]) ? "PASS" : "FAIL");
        }
    }
}

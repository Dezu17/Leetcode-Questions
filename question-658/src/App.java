import java.util.*;

public class App {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = k - 1;
        boolean foundResult = false;
        while (right < arr.length && !foundResult)
            if (right + 1 < arr.length && (Math.abs(arr[right + 1] - x) <
                Math.max(Math.abs(arr[right] - x), Math.abs(arr[left] - x)) ||
                (arr[left] == arr[right] && arr[right] == arr[right + 1]))) {
                left++;
                right++;
            }
            else
                foundResult = true;
        List<Integer> result = new ArrayList<>();
        for (int index = left; index <= right; index++)
            result.add(arr[index]);
        return result;
    }

    public static void main(String[] args) throws Exception {
        App solution = new App();

        System.out.println(solution.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
        System.out.println(solution.findClosestElements(new int[] { 1, 1, 2, 3, 4, 5 }, 4, -1));
        System.out.println(solution.findClosestElements(new int[] { 2, 4, 5, 8 }, 2, 6));
        System.out.println(solution.findClosestElements(new int[] { 2, 3, 4 }, 3, 1));
        System.out.println(solution.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 10));
    }
}

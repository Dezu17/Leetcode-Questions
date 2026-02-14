public class App {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxCapacity = 0;
        while (left < right) {
            int currentCapacity = 0;
            if (height[left] < height[right]) {
                currentCapacity = height[left] * (right - left);
                left++;
            } else {
                currentCapacity = height[right] * (right - left);
                right--;
            }
            if (currentCapacity > maxCapacity)
                maxCapacity = currentCapacity;
        }
        return maxCapacity;
    }

    public static void main(String[] args) {
        int[] height = { 1, 1 };
        System.out.print("Result: " + maxArea(height));
    }
}

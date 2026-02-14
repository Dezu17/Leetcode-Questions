public class App {
    public static int trap(int[] height) {
        int left = 1, right = height.length - 2;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int totalWater = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                if (leftMax > height[left])
                    totalWater = totalWater + leftMax - height[left];
                else if (leftMax < height[left])
                    leftMax = height[left];
                left++;
            } else {
                if (rightMax > height[right])
                    totalWater = totalWater + rightMax - height[right];
                else if (rightMax < height[right])
                    rightMax = height[right];
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.print("Result: " + trap(height));
    }
}
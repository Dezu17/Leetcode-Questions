public class App {
    public int maxProduct(int[] nums) {
        int currentMaxProduct = nums[0], currentMinProduct = nums[0], maxProduct = nums[0];
        for (int index = 1; index < nums.length; index++) {
            int aux = Math.max(nums[index], Math.max(nums[index] * currentMaxProduct, nums[index] * currentMinProduct));
            currentMinProduct = Math.min(nums[index], Math.min(nums[index] * currentMaxProduct, nums[index] * currentMinProduct));
            currentMaxProduct = aux;
            maxProduct = Math.max(currentMaxProduct, maxProduct);
        }
        return maxProduct;
    }
    public static void main(String[] args) throws Exception {
        int[][] tests = {
            {2, 3, -2, 4},
            {-2, 0, -1},
            {2, 4, -3, 5},
            {-3, 0, -2}
        };

        for (int[] nums : tests) {
            System.out.println(new App().maxProduct(nums));
        }
    }
}

public class App {
    int sum;

    private void backtrack(int[] nums, int index, int currentResult) {
        if (index < nums.length) {
            backtrack(nums, index + 1, currentResult);
            backtrack(nums, index + 1, currentResult ^ nums[index]);
            return;
        }
        sum += currentResult;
    }

    public int subsetXORSum(int[] nums) {
        sum = 0;
        backtrack(nums, 0, 0);
        return sum;
    }
    
    public static void main(String[] args) throws Exception {
        App app = new App();

        System.out.println(app.subsetXORSum(new int[] { 1, 3 }));
        System.out.println(app.subsetXORSum(new int[] { 5, 1, 6 }));
        System.out.println(app.subsetXORSum(new int[] { 3, 4, 5, 6, 7, 8 }));
        System.out.println(app.subsetXORSum(new int[] { 2, 4 }));
        System.out.println(app.subsetXORSum(new int[] { 3, 1, 1 }));
    }
}

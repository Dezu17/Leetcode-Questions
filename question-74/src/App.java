public class App {
    private int findRow(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1])
                return mid;
            else if (matrix[mid][0] > target)
                bottom = mid - 1;
            else
                top = mid + 1;
        }
        return -1;
    }
    private int findColumn(int[] row, int target) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (row[mid] == target)
                return mid;
            else if (row[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1)
            return false;
        int column = findColumn(matrix[row], target);
        if (column == -1)
            return false;
        return true;
    }
    public static void main(String[] args) throws Exception {
		testSearchMatrix(new int[][] {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60}
		}, 3, true);
		testSearchMatrix(new int[][] {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 60}
		}, 13, false);
		testSearchMatrix(new int[][] {{1}}, 1, true);
		testSearchMatrix(new int[][] {{1}}, 2, false);
	}

	private static void testSearchMatrix(int[][] matrix, int target, boolean expected) {
		boolean actual = new App().searchMatrix(matrix, target);
		if (actual != expected) {
			throw new AssertionError("Expected " + expected + " but got " + actual);
		}
		System.out.println("Passed: target " + target + " -> " + actual);
    }
}

public class App {
    private int getIslandArea(int[][] grid, int row, int column) {
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == 1) {
            grid[row][column] = 0;
            return 1 + getIslandArea(grid, row + 1, column) + getIslandArea(grid, row - 1, column) +
                getIslandArea(grid, row, column - 1) + getIslandArea(grid, row, column + 1);
        }
        return 0;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++)
                if (grid[row][column] == 1) {
                int area = getIslandArea(grid, row, column);
                if (maxArea < area)
                    maxArea = area;
                }
        return maxArea;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][][] tests = {
            {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
            },
            {
                {0, 0, 0, 0, 0, 0, 0, 0}
            },
            {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1}
            }
        };

        int[] expected = {6, 0, 6};
        for (int index = 0; index < tests.length; index++)
            System.out.println(app.maxAreaOfIsland(tests[index]) + " (expected " + expected[index] + ")");
    }
}

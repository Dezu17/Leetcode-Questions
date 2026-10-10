public class App {
    private boolean checkOutsidePerimeter(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length)
            return true;
        if (grid[row][column] == 0)
            return true;
        return false;
    }

    private int getPerimeter(int[][] grid, int row, int column) {
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == 1) {
            int perimeter = 0;
            int[][] coordinates = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int index = 0; index < coordinates.length; index++)
            if (checkOutsidePerimeter(grid, row + coordinates[index][0], column + coordinates[index][1]))
                perimeter++;
            grid[row][column] = 2;
            for (int index = 0; index < coordinates.length; index++)
                perimeter += getPerimeter(grid, row + coordinates[index][0], column + coordinates[index][1]);
            return perimeter;
        }
        return 0;
    }

    public int islandPerimeter(int[][] grid) {
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++)
            if (grid[row][column] == 1)
                return getPerimeter(grid, row, column);
        return 0;
    }
    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] example1 = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };
        System.out.println(app.islandPerimeter(example1));

        int[][] example2 = {{1}};
        System.out.println(app.islandPerimeter(example2));

        int[][] example3 = {{1, 0}};
        System.out.println(app.islandPerimeter(example3));

        int[][] example4 = {
            {1, 1, 0, 0},
            {1, 0, 0, 0},
            {1, 1, 1, 0},
            {0, 0, 1, 1}
        };
        System.out.println(app.islandPerimeter(example4));
    }
}

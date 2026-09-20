public class App {
    private void handleIsland(char[][] grid, int row, int column) {
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == '1') {
            grid[row][column] = '0';
            handleIsland(grid, row + 1, column);
            handleIsland(grid, row - 1, column);
            handleIsland(grid, row, column + 1);
            handleIsland(grid, row, column - 1);
        }
    }

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++)
                if (grid[row][column] == '1') {
                    handleIsland(grid, row, column);
                    islandCount++;
                }
        return islandCount;
    }
    
    public static void main(String[] args) {
        App app = new App();

        char[][][] tests = {
            {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
            },
            {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
            },
            {
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
            }
        };

        for (char[][] grid : tests)
            System.out.println(app.numIslands(grid));
    }
}

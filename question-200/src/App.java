public class App {
    private static void dfs(char[][] grid, boolean[][] visited, int row, int column) {
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length &&
            grid[row][column] == '1') {
            visited[row][column] = true;
            grid[row][column] = '0';
            dfs(grid, visited, row - 1, column);
            dfs(grid, visited, row, column - 1);
            dfs(grid, visited, row, column + 1);
            dfs(grid, visited, row + 1, column);
        }
    }
    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count  = 0;
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++)
                if (grid[row][column] == '1') {
                    count++;
                    dfs(grid, visited, row, column);
                }
        return count;
    }
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }
}

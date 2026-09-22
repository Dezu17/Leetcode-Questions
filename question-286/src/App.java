import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class App {
    private int handleNeighbours(int[][] grid, Queue<int[]> treasure, int row, int column, int distance) {
        int[][] coordinates = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int count = 0;
        for (int index = 0; index < 4; index++) {
            int newRow = row + coordinates[index][0], newColumn = column + coordinates[index][1];
            if (newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length && grid[newRow][newColumn] != -1)
            if (grid[newRow][newColumn] > distance) {
                grid[newRow][newColumn] = distance;
                treasure.add(new int[] {newRow, newColumn});
                count++;
            }
        }
        return count;
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> treasure = new LinkedList<>();
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++)
            if (grid[row][column] == 0)
                treasure.add(new int[] { row, column });
        if (treasure.isEmpty())
            return;
        int count = treasure.size(), distance = 1;
        while (!treasure.isEmpty()) {
            int currentCount = 0;
            for (int index = 0; index < count; index++) {
                int[] pair = treasure.remove();
                currentCount += handleNeighbours(grid, treasure, pair[0], pair[1], distance);
            }
            if (currentCount != 0) {
                count = currentCount;
                distance++;
            }
        }
    }

    
    public static void main(String[] args) throws Exception {
        App app = new App();
        int empty = Integer.MAX_VALUE;

        int[][][] tests = {
            {
                {empty, -1, 0, empty},
                {empty, empty, empty, -1},
                {empty, -1, empty, -1},
                {0, -1, empty, empty}
            },
            {
                {0, -1},
                {empty, empty}
            }
        };

        int[][][] expected = {
            {
                {3, -1, 0, 1},
                {2, 2, 1, -1},
                {1, -1, 2, -1},
                {0, -1, 3, 4}
            },
            {
                {0, -1},
                {1, 2}
            }
        };

        for (int index = 0; index < tests.length; index++) {
            app.islandsAndTreasure(tests[index]);
            System.out.println(Arrays.deepToString(tests[index]));
        }
    }
}

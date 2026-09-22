import java.util.Queue;
import java.util.LinkedList;

public class App {
    private int checkNeighbours(int[][] grid, Queue<int[]> rottenOranges, int row, int column) {
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int index = 0 ; index < 4; index++) {
            int nextRow = directions[index][0] + row;
            int nextColumn = directions[index][1] + column;

            if (nextRow >= 0 && nextRow < grid.length &&
                nextColumn >= 0 && nextColumn < grid[0].length &&
                grid[nextRow][nextColumn] == 1) {
                grid[nextRow][nextColumn] = 2;
                rottenOranges.add(new int[] { nextRow, nextColumn });
                count++;
            }
        }
        return count;
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenOranges = new LinkedList<>();
        boolean foundFruit = false;
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++)
                if (grid[row][column] == 2)
                    rottenOranges.add(new int[] { row, column });
                else if (grid[row][column] == 1)
                    foundFruit = true;
        if (rottenOranges.isEmpty() && foundFruit)
            return -1;
        else if (rottenOranges.isEmpty())
            return 0;
        int queueSize = rottenOranges.size(), minTime = 0;
        while (!rottenOranges.isEmpty()) {
            int count = 0;
            for (int index = 1; index <= queueSize; index++) {
            int[] pair = rottenOranges.remove();
            count += checkNeighbours(grid, rottenOranges, pair[0], pair[1]);
            }
            queueSize = count;
            if (count > 0)
                minTime++;
        }
        for (int row = 0; row < grid.length; row++)
            for (int column = 0; column < grid[0].length; column++)
                if (grid[row][column] == 1)
                return -1;
        return minTime;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][][] tests = {
            {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}},
            {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}},
            {{0, 2}},
            {{1, 1, 0}, {0, 1, 1}, {0, 1, 2}},
            {{1, 0, 1}, {0, 2, 0}, {1, 0, 1}}
        };

        int[] expected = {4, -1, 0, 4, -1};
        for (int index = 0; index < tests.length; index++)
            System.out.println(app.orangesRotting(tests[index]) + " (expected " + expected[index] + ")");
    }
}

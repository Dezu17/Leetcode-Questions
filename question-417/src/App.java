import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class App {
    Set<List<Integer>> reachPacific, reachAtlantic;
    boolean[][] visitedPacific, visitedAtlantic;

    private void dfs(int[][] heights, int row, int column, int lastElement, boolean handlePacific) {
        if (row < 0 || row >= heights.length || column < 0 || column >= heights[0].length ||
            (handlePacific && visitedPacific[row][column]) || (!handlePacific && visitedAtlantic[row][column]))
            return;
        if (lastElement <= heights[row][column]) {
            if (handlePacific)
                reachPacific.add(Arrays.asList(row, column));
            else
                reachAtlantic.add(Arrays.asList(row, column));
            int[][] coordinates = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            if (handlePacific)
                visitedPacific[row][column] = true;
            else
                visitedAtlantic[row][column] = true;
            for (int index = 0; index < coordinates.length; index++)
            dfs(heights, row + coordinates[index][0], column + coordinates[index][1], heights[row][column], handlePacific);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        visitedPacific = new boolean[heights.length][heights[0].length];
        visitedAtlantic = new boolean[heights.length][heights[0].length];
        for (int index = 0; index < visitedPacific.length; index++) {
            Arrays.fill(visitedPacific[index], false);
            Arrays.fill(visitedAtlantic[index], false);
        }
        reachPacific = new HashSet<>();
        reachAtlantic = new HashSet<>();
        for (int index = 0; index < heights.length; index++) {
            dfs(heights, index, 0, heights[index][0], true);
            dfs(heights, index, heights[0].length - 1, heights[index][heights[0].length - 1], false);
        }
        for (int index = 0; index < heights[0].length; index++) {
            dfs(heights, 0, index, heights[0][index], true);
            dfs(heights, heights.length - 1, index, heights[heights.length - 1][index], false);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < heights.length; row++)
            for (int column = 0; column < heights[0].length; column++)
            if (reachPacific.contains(Arrays.asList(row, column)) && reachAtlantic.contains(Arrays.asList(row, column)))
                result.add(Arrays.asList(row, column));
        return result;
    }

        private static void testPacificAtlantic(int[][] heights, int[][] expectedCoordinates) {
            List<List<Integer>> expected = new ArrayList<>();
            for (int[] coordinate : expectedCoordinates)
                expected.add(Arrays.asList(coordinate[0], coordinate[1]));

            List<List<Integer>> actual = new App().pacificAtlantic(heights);
            if (!actual.equals(expected))
                throw new AssertionError("Expected " + expected + " but got " + actual);
            System.out.println("Passed: " + actual);
        }

    public static void main(String[] args) throws Exception {
            testPacificAtlantic(
                    new int[][] {
                        {1, 2, 2, 3, 5},
                        {3, 2, 3, 4, 4},
                        {2, 4, 5, 3, 1},
                        {6, 7, 1, 4, 5},
                        {5, 1, 1, 2, 4}
                    },
                    new int[][] {{0, 4}, {1, 3}, {1, 4}, {2, 2}, {3, 0}, {3, 1}, {4, 0}});
            testPacificAtlantic(
                    new int[][] {{1}},
                    new int[][] {{0, 0}});
            testPacificAtlantic(
                    new int[][] {
                        {4, 2, 7, 3, 4},
                        {7, 4, 6, 4, 7},
                        {6, 3, 5, 3, 6}
                    },
                    new int[][] {{0, 2}, {0, 4}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 0}});
            testPacificAtlantic(
                    new int[][] {{1}, {1}},
                    new int[][] {{0, 0}, {1, 0}});
    }
}

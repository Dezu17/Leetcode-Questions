import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class App {
    List<List<Integer>> adjacencyList;
    boolean[] visited;

    private boolean checkNoCycle(int node, Set<Integer> path) {
        if (visited[node] == true && path.contains(node))
            return false;
        visited[node] = true;
        path.add(node);
        List<Integer> adjacentNodes = adjacencyList.get(node);
        for (int index = 0; index < adjacentNodes.size(); index++)
            if (!checkNoCycle(adjacentNodes.get(index), path))
                return false;
        path.remove(node);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjacencyList = new ArrayList<>();
        visited = new boolean[numCourses];
        for (int index = 0; index < numCourses; index++) {
            adjacencyList.add(new ArrayList<>());
            visited[index] = false;
        }
        for (int index = 0; index < prerequisites.length; index++)
            adjacencyList.get(prerequisites[index][0]).add(prerequisites[index][1]);
        for (int index = 0; index < visited.length; index++)
            if (visited[index] == false)
                if (!checkNoCycle(index, new HashSet<>()))
                    return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        System.out.println(app.canFinish(2, new int[][] {{1, 0}}));
        System.out.println(app.canFinish(2, new int[][] {{0, 1}}));
        System.out.println(app.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
    }
}

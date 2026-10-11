import java.util.*;

public class App {
    private boolean checkQuery(Map<Integer, Set<Integer>> adjacencyList, boolean[] visited, int a, int b) {
        if (!adjacencyList.containsKey(a) || visited[a])
            return false;
        visited[a] = true;
        Set<Integer> courses = adjacencyList.get(a);
        for (int course : courses) {
            if (course == b)
                return true;
            if (checkQuery(adjacencyList, visited, course, b))
                return true;
        }
        return false;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for (int index = 0; index < prerequisites.length; index++) {
            Set<Integer> courses = null;
            if (!adjacencyList.containsKey(prerequisites[index][0]))
                courses = new HashSet<>();
            else
                courses = adjacencyList.get(prerequisites[index][0]);
            courses.add(prerequisites[index][1]);
            adjacencyList.put(prerequisites[index][0], courses);
        }
        boolean[] visited = new boolean[numCourses];
        List<Boolean> result = new ArrayList<>();
        for (int index = 0; index < queries.length; index++) {
            Arrays.fill(visited, false);
            result.add(checkQuery(adjacencyList, visited, queries[index][0], queries[index][1]));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        testCheckIfPrerequisite(2, new int[][] {{1, 0}}, new int[][] {{0, 1}, {1, 0}},
            List.of(false, true));
        testCheckIfPrerequisite(2, new int[][] {}, new int[][] {{1, 0}, {0, 1}},
            List.of(false, false));
        testCheckIfPrerequisite(3, new int[][] {{1, 2}, {1, 0}, {2, 0}}, new int[][] {{1, 0}, {1, 2}},
            List.of(true, true));
        testCheckIfPrerequisite(4, new int[][] {{1, 0}, {2, 1}, {3, 2}}, new int[][] {{0, 1}, {3, 1}},
            List.of(false, true));
        testCheckIfPrerequisite(2, new int[][] {{1, 0}}, new int[][] {{0, 1}},
            List.of(false));
        }

        private static void testCheckIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries,
            List<Boolean> expected) {
        List<Boolean> actual = new App().checkIfPrerequisite(numCourses, prerequisites, queries);
        if (!actual.equals(expected))
            throw new AssertionError("Expected " + expected + ", but got " + actual);
        System.out.println("Passed: " + expected);
    }
}

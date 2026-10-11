import java.util.*;

public class App {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> innerDegree = new HashMap<>();
        Map<Integer, Integer> outerDegree = new HashMap<>();
        for (int person = 1; person <= n; person++) {
            innerDegree.put(person, 0);
            outerDegree.put(person, 0);
        }
        for (int index = 0; index < trust.length; index++) {
            innerDegree.put(trust[index][1], innerDegree.get(trust[index][1]) + 1);
            outerDegree.put(trust[index][0], outerDegree.get(trust[index][0]) + 1);
        }
        for (int person = 1; person <= n; person++)
            if (outerDegree.containsKey(person) && outerDegree.get(person) == 0 && innerDegree.get(person) == n - 1)
                return person;
        return -1;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        int[][] example1 = {{1, 2}};
        System.out.println(app.findJudge(2, example1));

        int[][] example2 = {{1, 3}, {2, 3}};
        System.out.println(app.findJudge(3, example2));

        int[][] example3 = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(app.findJudge(3, example3));

        int[][] example4 = {{1, 3}, {4, 3}, {2, 3}};
        System.out.println(app.findJudge(4, example4));

        int[][] example5 = {{1, 3}, {2, 3}, {3, 1}, {3, 2}};
        System.out.println(app.findJudge(3, example5));
    }
}

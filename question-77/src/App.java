import java.util.*;

public class App {
    List<List<Integer>> result;

    private void backtrack(List<Integer> current, int element, int n, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (element > n)
            return;
        backtrack(current, element + 1, n, k);
        current.add(element);
        backtrack(current, element + 1, n, k);
        current.remove(current.size() - 1);
        
    }

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, n, k);
        return result;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        System.out.println(app.combine(3, 2));
        System.out.println(app.combine(3, 3));
        System.out.println(app.combine(4, 2));
        System.out.println(app.combine(1, 1));
    }
}

public class App {
    private static int factorial(int n) {
        int result = 1;
        for (int count = 2; count <= n; count++)
            result *= count;
        return result;
    }

    public static int uniquePaths(int m, int n) {
        return factorial(m + n - 2) / (factorial(m - 1) * factorial(n - 1));
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(80, 2));
    }
}

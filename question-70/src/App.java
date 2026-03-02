public class App {
    public static int climbStairs(int n) {
        int previous1 = 1, previous2 = 1, current = 0;
        for (int index = 2; index <= n; index++) {
            current = previous1 + previous2;
            previous2 = previous1;
            previous1 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}

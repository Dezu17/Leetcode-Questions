import java.util.*;

public class App {
    private boolean backtrack(int[] matchsticks, Map<String, Boolean> dp, int index, int sum1, int sum2, int sum3, int sum4) {
        if (index == matchsticks.length && sum1 == sum2 && sum2 == sum3 && sum3 == sum4)
            return true;
        else if (index == matchsticks.length)
            return false;
        String key = index + "," + sum1 + "," + sum2 + "," + sum3 + "," + sum4;
        if (dp.containsKey(key))
            return dp.get(key);
        boolean result = backtrack(matchsticks, dp, index + 1, sum1 + matchsticks[index], sum2, sum3, sum4) ||
                        backtrack(matchsticks, dp, index + 1, sum1, sum2 + matchsticks[index], sum3, sum4) ||
                        backtrack(matchsticks, dp, index + 1, sum1, sum2, sum3 + matchsticks[index], sum4) ||
                        backtrack(matchsticks, dp, index + 1, sum1, sum2, sum3, sum4 + matchsticks[index]);
        dp.put(key, result);
        return result;
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int index = 0; index < matchsticks.length; index++)
            sum += matchsticks[index];
        if (sum % 4 != 0)
            return false;
        return backtrack(matchsticks, new HashMap<>(), 0, 0, 0, 0, 0);
    }
    
    public static void main(String[] args) throws Exception {
        App app = new App();

        int[] example1 = {1, 1, 2, 2, 2};
        System.out.println(app.makesquare(example1));

        int[] example2 = {3, 3, 3, 3, 4};
        System.out.println(app.makesquare(example2));

        int[] example3 = {1, 3, 4, 2, 2, 4};
        System.out.println(app.makesquare(example3));

        int[] example4 = {1, 5, 6, 3};
        System.out.println(app.makesquare(example4));
    }
}

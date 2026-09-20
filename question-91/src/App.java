public class App {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if (s.length() == 1)
            if (s.charAt(0) == '0')
                return 0;
            else
                return 1;
        dp[dp.length - 1] = 1;
        for (int index = s.length() - 1; index >= 0; index--) {
            if (s.charAt(index) == '0')
                dp[index] = 0;
            else
                dp[index] = dp[index + 1];
            if (index < s.length() - 1)
                if ((s.charAt(index) == '2' && s.charAt(index + 1) <= '6') ||
                (s.charAt(index) == '1' && s.charAt(index + 1) <= '9'))
                    dp[index] = dp[index] + dp[index + 2];
        }
        return dp[0];
    }
    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.numDecodings("12"));
        System.out.println(app.numDecodings("226"));
        System.out.println(app.numDecodings("06"));
        System.out.println(app.numDecodings("02"));
        System.out.println(app.numDecodings("102"));
        System.out.println(app.numDecodings("271"));
        System.out.println(app.numDecodings("0"));
    }
}

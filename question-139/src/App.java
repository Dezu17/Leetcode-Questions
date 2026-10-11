import java.util.*;

public class App {
    private boolean checkWord(String s, List<String> wordDict, int[] dp, int sIndex) {
        if (sIndex == s.length())
            return true;
        if (dp[sIndex] != -1)
            return dp[sIndex] == 0 ? false : true;
        dp[sIndex] = 0;
        for (int index = 0; index < wordDict.size(); index++)
            if (sIndex + wordDict.get(index).length() <= s.length() &&
                s.substring(sIndex, sIndex + wordDict.get(index).length()).equals(wordDict.get(index)) &&
                checkWord(s, wordDict, dp, sIndex + wordDict.get(index).length())) {
                dp[sIndex] = 1;
                return true;
            }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return checkWord(s, wordDict, dp, 0);
    }

    public static void main(String[] args) throws Exception {
        testWordBreak("leetcode", List.of("leet", "code"), true);
        testWordBreak("applepenapple", List.of("apple", "pen"), true);
        testWordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false);
        testWordBreak("catsincars", List.of("cats", "cat", "sin", "in", "car"), false);
        testWordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            List.of("aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa", "ba"), false);
    }

    private static void testWordBreak(String s, List<String> wordDict, boolean expected) {
        boolean actual = new App().wordBreak(s, wordDict);
        if (actual != expected)
            throw new AssertionError("Expected " + expected + " for " + s + ", but got " + actual);
        System.out.println("Passed: " + s);
    }
}

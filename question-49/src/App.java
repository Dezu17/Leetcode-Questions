import java.util.*;

public class App {
    private static String getHash(String s) {
        int[] fr = new int[26];
        for (int index = 0; index < s.length(); index++)
            fr[s.charAt(index) - 'a']++;
        String hash = "$";
        for (int index = 0; index < 26; index++)
            if (fr[index] != 0) {
                hash += ('a' + index);
                hash += String.valueOf(fr[index]);
            }
        return hash;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Hashtable<String, ArrayList<String>> groups = new Hashtable<>();
        for (int index = 0; index < strs.length; index++) {
            String hash = getHash(strs[index]);
            if (groups.containsKey(hash))
                groups.get(hash).add(strs[index]);
            else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(strs[index]);
                groups.put(hash, newList);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : groups.keySet())
            result.add(groups.get(key));
        return result;
    }

    public static void main(String[] args) {
        String[] strs = { "bdddddddddd", "bbbbbbbbbbc" };
        List<List<String>> result = groupAnagrams(strs);
        for (int index = 0; index < result.size(); index++)
            System.out.println(result.get(index));
    }
}

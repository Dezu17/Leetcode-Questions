public class App {
    int index;

    private String decode(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder(), currentString = new StringBuilder();
        while (index < s.length()) {
            if ('0' <= s.charAt(index) && s.charAt(index) <= '9')
                count = count * 10 + (s.charAt(index) - '0');
            else if ('a' <= s.charAt(index) && s.charAt(index) <= 'z')
                currentString.append(s.charAt(index));
            else if (s.charAt(index) == '[') {
                if (!currentString.equals(""))
                    result.append(currentString);
                index++;
                currentString = new StringBuilder();
                currentString.append(decode(s));
                if (count == 0)
                    result.append(currentString);
                else
                    for (int current = 0; current < count; current++)
                    result.append(currentString);
                count = 0;
                currentString = new StringBuilder();
            }
            else {
                if (!currentString.equals(""))
                    result.append(currentString);
                return result.toString();
            }
            index++;
        }
        if (!currentString.equals(""))
            result.append(currentString);
        return result.toString();
    }

    public String decodeString(String s) {
        index = 0;
        return decode(s);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        System.out.println(app.decodeString("3[a]2[bc]"));
        System.out.println(app.decodeString("3[a2[c]]"));
        System.out.println(app.decodeString("2[abc]3[cd]ef"));
        System.out.println(app.decodeString("2[a3[b]]c"));
        System.out.println(app.decodeString("axb3[z]4[c]"));
        System.out.println(app.decodeString("ab2[c]3[d]1[x]"));
    }
}

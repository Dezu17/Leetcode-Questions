public class Program
{
    private static bool IsDigit(char c)
    {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
    private static bool IsAlpha(char c)
    {
        if (c >= 'a' && c <= 'z')
            return true;
        return false;
    }
    public static string DecodeString(string s)
    {
        Stack<int> counts = new Stack<int>();
        Stack<string> sequences = new Stack<string>();
        int count = 0;
        string sequence = "";
        for (int index = 0; index < s.Length; index++)
        {
            if (IsDigit(s[index]))
                count = count * 10 + (s[index] - '0');
            else if (IsAlpha(s[index]))
                sequence += s[index];
            else if (s[index] == '[')
            {
                counts.Push(count);
                sequences.Push(sequence);
                count = 0;
                sequence = "";
            }
            else if (s[index] == ']')
            {
                count = counts.Pop();
                string result = "";
                for (int current = 0; current < count; current++)
                    result += sequence;
                sequence = sequences.Pop() + result;
                count = 0;
            }
        }
        return sequence;
    }
    public static void Main(String[] args)
    {
        string s = "2[abc]3[cd]ef";
        Console.WriteLine(DecodeString(s));
    }
}
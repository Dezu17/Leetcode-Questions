public class Program
{
    private static bool CheckIsMatch(string s, string p, int indexS, int indexP)
    {
        if (indexP == 0)
            if (indexS == 0)
                return true;
            else
                return false;
        if (indexS == 0)
            if (indexP > 1 && p[indexP - 1] == '*')
                return CheckIsMatch(s, p, indexS, indexP - 2);
            else
                return false;
        if (p[indexP - 1] == s[indexS - 1])
            return CheckIsMatch(s, p, indexS - 1, indexP - 1);
        if (p[indexP - 1] == '.')
            return CheckIsMatch(s, p, indexS - 1, indexP - 1);
        if (p[indexP - 1] == '*' && indexP > 1)
        {
            bool isZero = CheckIsMatch(s, p, indexS, indexP - 2);
            bool isOneOrMore = false;
            if (p[indexP - 2] == s[indexS - 1] || p[indexP - 2] == '.')
                isOneOrMore = CheckIsMatch(s, p, indexS - 1, indexP);
            if (isOneOrMore || isZero)
                return true;
        }
        return false;
    }
    public static bool IsMatch(string s, string p)
    {
        return CheckIsMatch(s, p, s.Length, p.Length);
    }
    public static void Main(string[] args)
    {
        string s = "aaa", p = "aaaa";
        Console.WriteLine(IsMatch(s, p));
    }
}
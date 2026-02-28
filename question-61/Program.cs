public class Program
{
    public static ListNode RotateRight(ListNode head, int k)
    {
        if (k == 0)
            return head;
        ListNode copy = head;
        int length = 0;
        while (copy != null)
        {
            copy = copy.next;
            length++;
        }
        if (k == 0)
            return null;
        int elementsToSkip = length - k % length - 1;
        copy = head;
        while (elementsToSkip-- > 0)
            copy = copy.next;
        ListNode end = copy;
        while (end.next != null)
            end = end.next;
        end.next = head;
        head = copy.next;
        copy.next = null;
        return head;
    }
    public static void Main(string[] args)
    {
        ListNode head = new ListNode();
        head = RotateRight(null, 1);
        while (head != null)
        {
            Console.WriteLine(head.val);
            head = head.next;
        }
    }
}
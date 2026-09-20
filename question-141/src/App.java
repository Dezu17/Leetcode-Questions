import java.util.HashSet;
import java.util.Set;

public class App {
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        if (head.next == null)
            return false;
        ListNode first = head, second = head.next;
        while (first != null && second != null) {
            if (first == second)
                return true;
            first = first.next;
            if (second.next != null)
                second = second.next.next;
            else
                return false;
        }
        return false;
    }

    private static ListNode buildList(int[] values, Integer pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        if (pos != null && pos >= 0 && pos < values.length) {
            ListNode cycleStart = dummy.next;
            for (int i = 0; i < pos; i++) {
                cycleStart = cycleStart.next;
            }
            current.next = cycleStart;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = buildList(new int[] {3, 2, 0, -4}, 1);
        ListNode head2 = buildList(new int[] {1, 2}, 0);
        ListNode head3 = buildList(new int[] {1}, -1);
        ListNode head4 = buildList(new int[] {}, -1);

        System.out.println(hasCycle(head1));
        System.out.println(hasCycle(head2));
        System.out.println(hasCycle(head3));
        System.out.println(hasCycle(head4));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

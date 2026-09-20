import java.util.ArrayList;
import java.util.List;

public class App {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode copy = head;
        while (copy != null) {
            copy = copy.next;
            size++;
        }
        if (size == n)
            return head.next;
        int stopIndex = size - n - 1;
        copy = head;
        for (int index = 0; index < stopIndex; index++)
            copy = copy.next;
        copy.next = copy.next.next;
        return head;
    }

    private static ListNode createList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static void assertListEquals(ListNode actual, int... expected) {
        for (int value : expected) {
            if (actual == null || actual.val != value)
                throw new AssertionError("Unexpected list result");
            actual = actual.next;
        }
        if (actual != null)
            throw new AssertionError("Unexpected list result");
    }

    public static void main(String[] args) {
        assertListEquals(removeNthFromEnd(createList(1, 2, 3, 4, 5), 2), 1, 2, 3, 5);
        assertListEquals(removeNthFromEnd(createList(1, 2), 1), 1);
        assertListEquals(removeNthFromEnd(createList(1), 1));
        System.out.println("All test cases passed.");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

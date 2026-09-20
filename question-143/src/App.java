import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class App {
    public static void reorderList(ListNode head) {
        if (head.next == null)
            return;
        int size = 0;
        ListNode copy = head;
        while (copy != null) {
            copy = copy.next;
            size++;
        }
        copy = head;
        for (int index = 0; index < size / 2; index++)
            copy = copy.next;
        ListNode secondHead = copy.next;
        copy.next = null;
        ListNode previous = null;
        copy = secondHead;
        while (copy != null) {
            ListNode aux = copy.next;
            copy.next = previous;
            previous = copy;
            copy = aux;
        }
        ListNode secondCopy = previous;
        copy = head;
        while (copy != null && secondCopy != null) {
            ListNode aux1 = copy.next, aux2 = secondCopy.next;
            copy.next = secondCopy;
            secondCopy.next = aux1;
            copy = aux1;
            secondCopy = aux2;
        }
    }
    
    public static void main(String[] args) throws Exception {
        test(new int[] { 1 }, new int[] { 1 });
        test(new int[] { 1, 2, 3, 4 }, new int[] { 1, 4, 2, 3 });
        test(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 5, 2, 4, 3 });
        test(new int[] { 2, 4, 6, 8 }, new int[] { 2, 8, 4, 6 });
        test(new int[] { 2, 4, 6, 8, 10 }, new int[] { 2, 10, 4, 8, 6 });
    }

    private static void test(int[] input, int[] expected) {
        ListNode head = ListNode.fromArray(input);
        reorderList(head);
        int[] actual = head.toArray();
        if (!Arrays.equals(actual, expected)) {
            throw new AssertionError("Expected " + Arrays.toString(expected)
                    + " but got " + Arrays.toString(actual));
        }
        System.out.println(Arrays.toString(input) + " -> " + Arrays.toString(actual));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    static ListNode fromArray(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    int[] toArray() {
        int size = 0;
        ListNode current = this;
        while (current != null) {
            size++;
            current = current.next;
        }

        int[] values = new int[size];
        current = this;
        for (int index = 0; index < size; index++) {
            values[index] = current.val;
            current = current.next;
        }
        return values;
    }
}

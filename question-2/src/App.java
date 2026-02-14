import java.util.List;

public class App {

    public static ListNode createList(ListNode l1, ListNode l2, int carry) {
        if (l1 != null && l2 != null) {
            ListNode nextListNode = createList(l1.next, l2.next, (l1.val + l2.val + carry) / 10);
            return new ListNode((l1.val + l2.val + carry) % 10, nextListNode);
        } else if (l1 != null) {
            ListNode nextListNode = createList(l1.next, null, (l1.val + carry) / 10);
            return new ListNode((l1.val + carry) % 10, nextListNode);
        } else if (l2 != null) {
            ListNode nextListNode = createList(null, l2.next, (l2.val + carry) / 10);
            return new ListNode((l2.val + carry) % 10, nextListNode);
        } else if (carry > 0) {
            return new ListNode(carry);
        } else
            return null;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return createList(l1, l2, 0);
    }

    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

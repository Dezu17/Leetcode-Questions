import java.util.List;

public class App {

    private static ListNode performAddition(ListNode l1, ListNode l2) {
        ListNode head = null, previous = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            ListNode currentNode = new ListNode();
            if (l1 != null && l2 != null) {
                currentNode.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 != null) {
                currentNode.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
            }
            else {
                currentNode.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
            }
            if (head == null) {
                head = currentNode;
                previous = currentNode;
            }
            else {
                previous.next = currentNode;
                previous = currentNode;
            }
        }
        if (carry != 0)
            previous.next = new ListNode(carry);
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return performAddition(l1, l2);
    }

    public static void main(String[] args) throws Exception {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

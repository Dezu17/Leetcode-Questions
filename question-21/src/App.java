import java.util.ArrayList;
import java.util.List;

public class App {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null, last = null;
        while (list1 != null && list2 != null) {
        ListNode newNode = new ListNode();
        if (list1.val > list2.val) {
            newNode.val = list2.val;
            list2 = list2.next;
        }
        else {
            newNode.val = list1.val;
            list1 = list1.next;
        }
        if (head == null) {
            head = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = last.next;
        }
        }
        while (list1 != null) {
        ListNode newNode = new ListNode(list1.val);
        list1 = list1.next;
        if (head == null) {
            head = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = last.next;
        }
        }
        while (list2 != null) {
        ListNode newNode = new ListNode(list2.val);
        list2 = list2.next;
        if (head == null) {
            head = newNode;
            last = newNode;
        }
        else {
            last.next = newNode;
            last = last.next;
        }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3));
        ListNode result = mergeTwoLists(list1, list2);
        for (ListNode current = result; current != null; current = current.next) {
            System.out.print(current.val + " ");
        }
    }
}

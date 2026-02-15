public class App {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val)
                return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
            else
                return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        } else if (list1 != null)
            return list1;
        else
            return list2;
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

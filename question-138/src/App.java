import java.util.HashMap;
import java.util.Map;

public class App {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node original = head;
        while (original != null) {
            Node copy = new Node(original.val);
            copy.next = original.next;
            original.next = copy;
            original = original.next.next;
            }
        original = head;
        while (original != null) {
            Node copy = original.next;
            if (original.random == null)
                copy.random = null;
            else
                copy.random = original.random.next;
            original = copy.next;
        }
        original = head;
        Node copyHead = head.next;
        while (original != null) {
            Node copy = original.next;
            original.next = copy.next;
            if (original.next == null)
                copy.next = null;
            else
                copy.next = original.next.next;
            original = original.next;
        }
        return copyHead;
    }

    public static void main(String[] args) throws Exception {
        testCopyRandomList(new int[][] {{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}});
        testCopyRandomList(new int[][] {{1, 1}, {2, 1}});
        testCopyRandomList(new int[][] {{3, -1}, {3, 0}, {3, -1}});
        testCopyRandomList(new int[][] {{3, -1}, {7, 3}, {4, 0}, {5, 1}});
        testCopyRandomList(new int[][] {{1, -1}, {2, 2}, {3, 2}});
    }

    private static void testCopyRandomList(int[][] specification) {
        Node original = createList(specification);
        Node copy = new App().copyRandomList(original);
        Node originalNode = original;
        Node copyNode = copy;

        for (int index = 0; index < specification.length; index++) {
            if (copyNode == null || copyNode == originalNode || copyNode.val != specification[index][0]) {
                throw new AssertionError("Copied list has an invalid node at index " + index);
            }
            int randomIndex = specification[index][1];
            Node expectedRandom = randomIndex == -1 ? null : getNode(original, randomIndex);
            if (copyNode.random == expectedRandom || copyNode.random == null && expectedRandom != null
                    || copyNode.random != null && copyNode.random.val != expectedRandom.val) {
                throw new AssertionError("Copied list has an invalid random pointer at index " + index);
            }
            originalNode = originalNode.next;
            copyNode = copyNode.next;
        }

        if (copyNode != null || originalNode != null) {
            throw new AssertionError("Copied list has an invalid length");
        }
        System.out.println("Passed random-list test");
    }

    private static Node createList(int[][] specification) {
        Node head = null;
        Node tail = null;
        Node[] nodes = new Node[specification.length];
        for (int index = 0; index < specification.length; index++) {
            nodes[index] = new Node(specification[index][0]);
            if (head == null) {
                head = nodes[index];
            } else {
                tail.next = nodes[index];
            }
            tail = nodes[index];
        }
        for (int index = 0; index < specification.length; index++) {
            int randomIndex = specification[index][1];
            nodes[index].random = randomIndex == -1 ? null : nodes[randomIndex];
        }
        return head;
    }

    private static Node getNode(Node head, int index) {
        while (index-- > 0) {
            head = head.next;
        }
        return head;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

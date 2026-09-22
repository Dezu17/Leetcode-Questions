import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> copies = new HashMap<>();
        Queue<Node> nodes = new LinkedList<>();
        Node copy = new Node(node.val);
        copies.put(node, copy);
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node currentNode = nodes.remove();
            for (Node currentNeighbour : currentNode.neighbors) {
                if (!copies.containsKey(currentNeighbour)) {
                    copies.put(currentNeighbour, new Node(currentNeighbour.val));
                    nodes.add(currentNeighbour);
                }
                copies.get(currentNode).neighbors.add(copies.get(currentNeighbour));
            }
        }
        return copies.get(node);
    }

    public static void main(String[] args) throws Exception {
        testCloneGraph(new int[][] {{2}, {1, 3}, {2}});
        testCloneGraph(new int[][] {{2, 4}, {1, 3}, {2, 4}, {1, 3}});
        testCloneGraph(new int[][] {{}});
        testCloneGraph(new int[][] {});
    }

    private static void testCloneGraph(int[][] adjacencyList) {
        Node original = createGraph(adjacencyList);
        Node copy = new App().cloneGraph(original);
        assertClone(original, copy, new IdentityHashMap<>());
        System.out.println("Passed graph test");
    }

    private static Node createGraph(int[][] adjacencyList) {
        if (adjacencyList.length == 0)
            return null;
        Node[] nodes = new Node[adjacencyList.length];
        for (int index = 0; index < nodes.length; index++)
            nodes[index] = new Node(index + 1);
        for (int index = 0; index < nodes.length; index++)
            for (int neighbor : adjacencyList[index])
                nodes[index].neighbors.add(nodes[neighbor - 1]);
        return nodes[0];
    }

    private static void assertClone(Node original, Node copy, Map<Node, Node> visited) {
        if (original == null) {
            if (copy != null)
                throw new AssertionError("Expected an empty cloned graph");
            return;
        }
        if (copy == null || copy == original || copy.val != original.val
                || copy.neighbors.size() != original.neighbors.size())
            throw new AssertionError("Cloned graph does not match the original");
        if (visited.containsKey(original)) {
            if (visited.get(original) != copy)
                throw new AssertionError("Cloned graph does not preserve shared edges");
            return;
        }
        visited.put(original, copy);
        for (int index = 0; index < original.neighbors.size(); index++)
            assertClone(original.neighbors.get(index), copy.neighbors.get(index), visited);
    }
}

class Node {
    int val;
    List<Node> neighbors = new ArrayList<>();

    Node(int val) {
        this.val = val;
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        else
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    private static TreeNode buildTree(Integer[] values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        int index = 1;
        while (!nodes.isEmpty() && index < values.length) {
            TreeNode node = nodes.poll();
            if (index < values.length && values[index] != null) {
                node.left = new TreeNode(values[index]);
                nodes.offer(node.left);
            }
            index++;
            if (index < values.length && values[index] != null) {
                node.right = new TreeNode(values[index]);
                nodes.offer(node.right);
            }
            index++;
        }
        return root;
    }

    private static List<Integer> toLevelOrder(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node == null) {
                values.add(null);
            } else {
                values.add(node.val);
                nodes.offer(node.left);
                nodes.offer(node.right);
            }
        }
        while (!values.isEmpty() && values.get(values.size() - 1) == null) {
            values.remove(values.size() - 1);
        }
        return values;
    }

    private static void runTest(Integer[] values, int val, List<Integer> expected) {
        App app = new App();
        List<Integer> actual = toLevelOrder(app.insertIntoBST(buildTree(values), val));
        if (!actual.equals(expected)) {
            throw new AssertionError("Expected " + expected + ", but got " + actual);
        }
        System.out.println("Passed: " + actual);
    }

    public static void main(String[] args) throws Exception {
        runTest(new Integer[]{4, 2, 7, 1, 3}, 5, List.of(4, 2, 7, 1, 3, 5));
        runTest(new Integer[]{40, 20, 60, 10, 30, 50, 70}, 25,
                List.of(40, 20, 60, 10, 30, 50, 70, null, null, 25));
        runTest(new Integer[]{4, 2, 7, 1, 3, null, null, null, null, null, null}, 5,
                List.of(4, 2, 7, 1, 3, 5));
    }
}

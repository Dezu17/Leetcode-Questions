import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class App {
    private int getMinNode(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;
        if (root.left == null)
            return Math.min(root.val, getMinNode(root.right));
        if (root.right == null)
            return Math.min(root.val, getMinNode(root.left));
        return Math.min(root.val, Math.min(getMinNode(root.left), getMinNode(root.right)));
    }

    private TreeNode deleteMinNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key)
            return root.right;
        root.left = deleteMinNode(root.left, key);
        root.right = deleteMinNode(root.right, key);
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (root.right == null)
            root = root.left;
            else {
                int minLeaf = getMinNode(root.right);
                root.val = minLeaf;
                root.right = deleteMinNode(root.right, minLeaf);
            }
            return root;
        }
        if (root.val > key)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        return root;
    }

    public static void main(String[] args) throws Exception {
        App solution = new App();

        runTest(solution, new Integer[] { 5, 3, 9, 1, 4 }, 3,
                Arrays.asList(5, 4, 9, 1));
        runTest(solution, new Integer[] { 5, 3, 6, null, 4, null, 10, null, null, 7 }, 3,
                Arrays.asList(5, 4, 6, null, null, null, 10, 7));
    }

    private static void runTest(App solution, Integer[] values, int key, List<Integer> expected) {
        List<Integer> actual = toLevelOrder(solution.deleteNode(buildTree(values), key));
        if (!actual.equals(expected))
            throw new AssertionError("Expected " + expected + ", but got " + actual);
        System.out.println("Passed: " + actual);
    }

    private static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null)
            return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int index = 1;

        while (!nodes.isEmpty() && index < values.length) {
            TreeNode node = nodes.remove();
            if (values[index] != null) {
                node.left = new TreeNode(values[index]);
                nodes.add(node.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                node.right = new TreeNode(values[index]);
                nodes.add(node.right);
            }
            index++;
        }
        return root;
    }

    private static List<Integer> toLevelOrder(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            if (node == null) {
                values.add(null);
                continue;
            }
            values.add(node.val);
            nodes.add(node.left);
            nodes.add(node.right);
        }

        while (!values.isEmpty() && values.get(values.size() - 1) == null)
            values.remove(values.size() - 1);
        return values;
    }
}

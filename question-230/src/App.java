import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class App {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> sortedNodes;

    private void createList(TreeNode root) {
        if (root != null) {
            createList(root.left);
            sortedNodes.add(root.val);
            createList(root.right);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        sortedNodes = new ArrayList<>();
	    createList(root);
	    return sortedNodes.get(k - 1);
    }

    private static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode current = queue.poll();

            if (current == null) {
                continue;
            }

            if (index < values.length && values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    private static void runTest(Integer[] values, int k) {
        App app = new App();
        TreeNode root = buildTree(values);
        System.out.println(app.kthSmallest(root, k));
    }

    public static void main(String[] args) throws Exception {
        runTest(new Integer[]{3, 1, 4, null, 2}, 1);
        runTest(new Integer[]{5, 3, 6, 2, 4, null, null, 1}, 3);
        runTest(new Integer[]{2, 1, 3}, 1);
        runTest(new Integer[]{4, 3, 5, 2, null}, 4);
    }
}

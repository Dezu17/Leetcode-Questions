class TreeNode {
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

public class App {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null)
            return null;
        return root;
    }
    
    public static void main(String[] args) throws Exception {
        App solution = new App();

        runTest(solution, new Integer[] {1, 2, 3, 2, null, 2, 4}, 2,
                java.util.Arrays.asList(1, null, 3, null, 4));
        runTest(solution, new Integer[] {1, 3, 3, 3, 2}, 3,
                java.util.Arrays.asList(1, 3, null, null, 2));
        runTest(solution, new Integer[] {1, 2, null, 2, null, 2}, 2,
                java.util.Arrays.asList(1));
        runTest(solution, new Integer[] {1, 2, 3, 5, 2, 2, 5}, 2,
                java.util.Arrays.asList(1, 2, 3, 5, null, null, 5));
        runTest(solution, new Integer[] {3, null, 3, 3}, 3,
                java.util.Collections.emptyList());
    }

    private static void runTest(App solution, Integer[] values, int target, java.util.List<Integer> expected) {
        java.util.List<Integer> actual = toLevelOrder(solution.removeLeafNodes(buildTree(values), target));
        if (!actual.equals(expected))
            throw new AssertionError("Expected " + expected + ", but got " + actual);
        System.out.println("Passed: " + actual);
    }

    private static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null)
            return null;

        TreeNode root = new TreeNode(values[0]);
        java.util.Queue<TreeNode> nodes = new java.util.LinkedList<>();
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

    private static java.util.List<Integer> toLevelOrder(TreeNode root) {
        java.util.List<Integer> values = new java.util.ArrayList<>();
        java.util.Queue<TreeNode> nodes = new java.util.LinkedList<>();
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

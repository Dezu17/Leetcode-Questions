public class App {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this(val, null, null);
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int countGoodNodes(TreeNode root, TreeNode current, TreeNode maxNode) {
        if (current == null)
        return 0;
        if (maxNode.val < current.val || root == current) {
        maxNode = current;
        return countGoodNodes(root, current.left, maxNode) + countGoodNodes(root, current.right, maxNode) + 1;
        }
        return countGoodNodes(root, current.left, maxNode) + countGoodNodes(root, current.right, maxNode);
    }
    
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root, root);
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

        TreeNode root1 = new TreeNode(2,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(1, new TreeNode(1), new TreeNode(5)));

        System.out.println("root = [2,1,1,3,null,1,5]");
        System.out.println("good nodes = " + app.goodNodes(root1));

        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(-1));

        System.out.println("root = [1,2,-1,3,4]");
        System.out.println("good nodes = " + app.goodNodes(root2));
    }
}

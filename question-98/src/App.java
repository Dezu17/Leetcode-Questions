import java.util.ArrayList;
import java.util.List;

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

    List<Integer> nodes;

    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            nodes.add(root.val);
            inorderTraversal(root.right);
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        nodes = new ArrayList<>();
        inorderTraversal(root);
        for (int index = 1; index < nodes.size(); index++)
        if (nodes.get(index - 1) >= nodes.get(index))
            return false;
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        App app = new App();

        TreeNode root1 = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));

        TreeNode root2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(6)));

        TreeNode root3 = new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3)));

        System.out.println("root = [2,1,3] -> " + app.isValidBST(root1));
        System.out.println("root = [5,1,4,null,null,3,6] -> " + app.isValidBST(root2));
        System.out.println("root = [1,2,3] -> " + app.isValidBST(root3));
    }
}

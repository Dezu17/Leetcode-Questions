import java.util.LinkedList;
import java.util.Queue;

public class App {

    public static int maxDepth(TreeNode root) {
        if (root != null) {
            int left = 1 + maxDepth(root.left);
            int right = 1 + maxDepth(root.right);
            return Math.max(left, right);
        }
        return 0;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        System.out.print("[");
        boolean first = true;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            if (!first) {
                System.out.print(",");
            }
            System.out.print(node.val);
            first = false;
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.print("root = ");
        printTree(root);
        System.out.println("max depth = " + maxDepth(root));
    }
}

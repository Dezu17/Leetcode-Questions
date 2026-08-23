import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode aux = root.left;
            root.left = root.right;
            root.right = aux;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
        return null;
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
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        System.out.print("root = ");
        printTree(root);
        invertTree(root);
        System.out.print("inverted root = ");
        printTree(root);
    }
}

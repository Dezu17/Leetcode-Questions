import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class App {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> groups = new ArrayList();
        if (root == null) 
        return groups;
        Queue<TreeNode> order = new LinkedList<>();
        order.add(root);
        int currentCount = 0, previousCount = 1;
        List<Integer> currentGroup = new ArrayList();
        do {
        if (previousCount > 0) {
            TreeNode currentNode = order.remove();
            previousCount--;
            if (currentNode.left != null) {
                order.add(currentNode.left);
                currentCount++;
            }
            if (currentNode.right != null) {
                order.add(currentNode.right);
                currentCount++;
            }
            currentGroup.add(currentNode.val);
        }
        else {
            groups.add(currentGroup);
            currentGroup = new ArrayList();
            previousCount = currentCount;
            currentCount = 0;
        }
        } while (!order.isEmpty());
        groups.add(currentGroup);
        return groups;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(app.levelOrder(root));
    }
}

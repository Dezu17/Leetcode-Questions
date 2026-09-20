public class App {
    private int getMaxHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getMaxHeight(root.left) + 1;
        int rightHeight = getMaxHeight(root.right) + 1;
        return Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftHeight = getMaxHeight(root.left);
        int rightHeight = getMaxHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

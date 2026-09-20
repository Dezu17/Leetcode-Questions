public class App {
    public static int maxDiameter;
    
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return -1;
        int leftDiameter = 1 + diameterOfBinaryTree(root.left);
        int rightDiameter = 1 + diameterOfBinaryTree(root.right);
        if (maxDiameter < leftDiameter + rightDiameter)
            maxDiameter = leftDiameter + rightDiameter;
        return Math.max(leftDiameter, rightDiameter);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3));

        maxDiameter = 0;
        System.out.println("root = [1,2,3,4,5]");
        diameterOfBinaryTree(root);
        System.out.println("diameter = " + maxDiameter);

        root = new TreeNode(1,
            null,
            new TreeNode(2,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(4)));

        maxDiameter = 0;
        System.out.println("root = [1,null,2,3,4,5]");
        diameterOfBinaryTree(root);
        System.out.println("diameter = " + maxDiameter);

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        maxDiameter = 0;
        System.out.println("root = [1,2,3]");
        diameterOfBinaryTree(root);
        System.out.println("diameter = " + maxDiameter);
    }
}

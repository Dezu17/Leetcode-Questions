public class App {
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    public static void main(String[] args) throws Exception {
		App app = new App();

		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);

		TreeNode q = new TreeNode(1);
		q.right = new TreeNode(2);

		System.out.println(app.isSameTree(p, q));

		p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);

		q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);

		System.out.println(app.isSameTree(p, q));

		p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(1);

		q = new TreeNode(1);
		q.left = new TreeNode(1);
		q.right = new TreeNode(2);

		System.out.println(app.isSameTree(p, q));
    }
}

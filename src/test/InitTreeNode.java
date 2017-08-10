package test;

public class InitTreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	InitTreeNode(int x) {
		this.val = x;
	}

	InitTreeNode(int x, TreeNode l, TreeNode r) {
		this.val = x;
		this.left = l;
		this.right = r;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}

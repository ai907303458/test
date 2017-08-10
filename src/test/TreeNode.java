package test;

public class TreeNode {
	char val;
	TreeNode left;
	TreeNode right;
	TreeNode(char x) {
		this.val = x;
	}
	TreeNode(char x, TreeNode l, TreeNode r) {
		this.val = x;
		this.left = l;
		this.right = r;
	}
	public char getVal() {
		return val;
	}
	public void setVal(char val) {
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

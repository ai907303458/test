package Basic;

public class TreeNode {
	private int IntVal;
	private char CharVal;
	private String StrVal;
	private long LongVal;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int x) {
		this.IntVal = x;
	}

	public TreeNode(char x, TreeNode l, TreeNode r) {
		this.CharVal = x;
		this.left = l;
		this.right = r;
	}

	public TreeNode(char x) {
		this.CharVal = x;
	}

	public TreeNode(int x, TreeNode l, TreeNode r) {
		this.IntVal = x;
		this.left = l;
		this.right = r;
	}

	public TreeNode(String x) {
		this.StrVal = x;
	}

	public TreeNode(String x, TreeNode l, TreeNode r) {
		this.StrVal = x;
		this.left = l;
		this.right = r;
	}

	public TreeNode(long x) {
		this.LongVal = x;
	}

	public TreeNode(long x, TreeNode l, TreeNode r) {
		this.LongVal = x;
		this.left = l;
		this.right = r;
	}

	public int getIntVal() {
		return IntVal;
	}

	public void setIntVal(int intVal) {
		IntVal = intVal;
	}

	public char getCharVal() {
		return CharVal;
	}

	public void setCharVal(char charVal) {
		CharVal = charVal;
	}

	public String getStrVal() {
		return StrVal;
	}

	public void setStrVal(String strVal) {
		StrVal = strVal;
	}

	public long getLongVal() {
		return LongVal;
	}

	public void setLongVal(long longVal) {
		LongVal = longVal;
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

package test;

public class TreeNode {
	private int IntVal;
	private char CharVal;
	private String StrVal;
	private long LongVal;
	private TreeNode left;
	private TreeNode right;

	TreeNode(int x) {
		this.IntVal = x;
	}

	TreeNode(char x, TreeNode l, TreeNode r) {
		this.CharVal = x;
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

	TreeNode(char x) {
		this.CharVal = x;
	}

	TreeNode(int x, TreeNode l, TreeNode r) {
		this.IntVal = x;
		this.left = l;
		this.right = r;
	}

	TreeNode(String x) {
		this.StrVal = x;
	}

	TreeNode(String x, TreeNode l, TreeNode r) {
		this.StrVal = x;
		this.left = l;
		this.right = r;
	}

	TreeNode(long x) {
		this.LongVal = x;
	}

	TreeNode(long x, TreeNode l, TreeNode r) {
		this.LongVal = x;
		this.left = l;
		this.right = r;
	}
}

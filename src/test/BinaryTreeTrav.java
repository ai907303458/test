package test;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTrav {
	/** 构造树 */
	public TreeNode treeInit() {
		TreeNode a = new TreeNode('A');
		TreeNode b = new TreeNode('B', null, a);
		TreeNode c = new TreeNode('C');
		TreeNode d = new TreeNode('D', b, c);
		TreeNode e = new TreeNode('E');
		TreeNode f = new TreeNode('F', e, null);
		TreeNode g = new TreeNode('G', null, f);
		TreeNode h = new TreeNode('H', d, g);
		return h;// root
	}

	/**
	 * 递归遍历
	 */

	/** 访问节点 */
	public void visit(TreeNode p) {
		System.out.print(p.getCharVal() + " ");
	}

	protected void preorder(TreeNode p) {
		if (p != null) {
			visit(p);
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}

	/** 递归实现中序遍历 */
	protected void inorder(TreeNode p) {
		if (p != null) {
			inorder(p.getLeft());
			visit(p);
			inorder(p.getRight());
		}
	}

	/** 递归实现后序遍历 */
	protected void postorder(TreeNode p) {
		if (p != null) {
			postorder(p.getLeft());
			postorder(p.getRight());
			visit(p);
		}
	}

	/**
	 * 层序遍历，广度优先搜索
	 * 
	 * @param pre
	 * @param in
	 * @return
	 */
	public void boardOrder(TreeNode p) {
		Queue<TreeNode> arr = new LinkedList<TreeNode>();
		arr.offer(p);
		while (!arr.isEmpty()) {
			TreeNode tn = arr.poll();
			System.out.print(tn.getCharVal() + " ");
			if (tn.left != null) {
				arr.add(tn.left);
			}
			if (tn.right != null) {
				arr.add(tn.right);
			}
		}
	}
}

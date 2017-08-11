package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTrav {
	/**
	 * 构造树
	 */
	public TreeNode treeInit() {
		TreeNode a = new TreeNode('A');
		TreeNode b = new TreeNode('B', null, a);
		TreeNode c = new TreeNode('C');
		TreeNode d = new TreeNode('D', b, c);
		TreeNode e = new TreeNode('E');
		TreeNode i = new TreeNode('I');
		TreeNode f = new TreeNode('F', e, i);
		TreeNode g = new TreeNode('G', null, f);
		TreeNode h = new TreeNode('H', d, g);
		return h;// root
	}

	/**
	 * 访问节点
	 */
	public void visit(TreeNode p) {
		System.out.print(p.getCharVal() + " ");
	}

	/**
	 * 递归前序遍历
	 * 
	 * @param p
	 */
	public void preorder(TreeNode p) {
		if (p != null) {
			visit(p);
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}

	/**
	 * 非递归前序遍历1
	 * 
	 * @param p
	 */
	public void preOrder1(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (p != null) {
			stack.push(p);
			while (!stack.isEmpty()) {
				p = stack.pop();
				visit(p);
				// 为什么getRight()在前，而p.getLeft()在后? 因为在栈中，先入后出，右子树的节点需要后续遍历，因此需要先将右子树节点先入栈。
				if (p.getRight() != null) {
					stack.push(p.getRight());
				}
				if (p.getLeft() != null) {
					stack.push(p.getLeft());
				}
			}
		}
	}

	/**
	 * 非递归前序遍历2 
	 * 每次都是走树的左分支(left)，直到左子树为空，然后开始从递归的最深处返回，然后开始恢复递归现场，访问右子树。
	 * 其实过程很简单：一直往左走 root->left->left->left...->null，由于是先序遍历，因此一遇到节点，便需要立即访问；
	 * 由于一直走到最左边后，需要逐步返回到父节点访问右节点，因此必须有一个措施能够对节点序列回溯。
	 * 用栈记忆：在访问途中将依次遇到的节点保存下来。由于节点出现次序与恢复次序是反序的，因此是一个先进后出结构，需要用栈。 
	 * 对于任一结点P：
	 * 1)访问结点P，并将结点P入栈;
	 * 2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，循环至1);若不为空，则将P的左孩子置为当前的结点P;
	 * 3)直到P为NULL并且栈为空，则遍历结束。
	 * 
	 * @param p
	 */
	public void preOrder2(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {// 压入所有的左节点，压入前访问它。左节点压入完后pop访问右节点。像这样算法时思考规律性的东西在哪。不管哪个节点都要压所节点判断右节点。
				visit(node);
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				node = node.getRight();
			}
		}
	}

	/**
	 * 递归实现中序遍历
	 * 
	 * @param p
	 */
	public void inorder(TreeNode p) {
		if (p != null) {
			inorder(p.getLeft());
			visit(p);
			inorder(p.getRight());
		}
	}

	/**
	 * 非递归中序遍历1 
	 * 根据中序遍历的顺序，对于任一结点，优先访问其左孩子，而左孩子结点又可以看做一根结点，然后继续访问其左孩子结点，
	 * 直到遇到左孩子结点为空的结点才进行访问，然后按相同的规则访问其右子树。
	 *  因此其处理过程如下：
	 *   对于任一结点P，
	 * 1)若其左孩子不为空，则将P入栈并将P的左孩子置为当前的P，然后对当前结点P再进行相同的处理；
	 * 2)若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶结点，然后将当前的P置为栈顶结点的右孩子； 
	 * 3)直到P为NULL并且栈为空则遍历结束
	 * 
	 * @param p
	 */
	public void inOrder1(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				visit(node); // 与preOrder2比较只有这句话的位置不一样，弹出时再访问。
				node = node.getRight();
			}
		}
	}

	/**
	 * 非递归中序遍历2
	 * 
	 * @param p
	 */
	public void inOrder2(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (p != null) {
			while (p != null) {
				if (p.getRight() != null) {
					stack.push(p.getRight());// 当前节点右子入栈
				}
				stack.push(p);// 当前节点入栈
				p = p.getLeft();
			}
			p = stack.pop();
			while (!stack.empty() && p.getRight() == null) {
				visit(p);
				p = stack.pop();
			}
			visit(p);
			if (!stack.empty())
				p = stack.pop();
			else
				p = null;
		}
	}

	/**
	 * 递归实现后序遍历
	 * 
	 * @param p
	 */
	public void postorder(TreeNode p) {
		if (p != null) {
			postorder(p.getLeft());
			postorder(p.getRight());
			visit(p);
		}
	}

	/**
	 * 非递归实现后序遍历1
	 * 对于任一结点P，
	 * 1)将其入栈，然后沿其左子树一直往下搜索入栈，直到搜索到没有左孩子的结点，
	 * 2）P不存在右孩子或者右孩子已经被访问，则可以直接访问它；
	 * 3)若非上述两种情况，说明p有右孩子没有访问，将p入栈，并将p设为p的右孩子，
	 *
	 * @param p
	 */
	public void postOrder1(TreeNode p) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p;
		while (p != null) {
			// 左子树入栈
			while (p.getLeft() != null) {
				stack.push(p);
				p = p.getLeft();
			}
			// 当前节点无右子或右子已经输出
			while (p != null && (p.getRight() == null || p.getRight() == node)) {
				visit(p);
				node = p;// 记录上一个已输出节点,判断是否输出过
				if (stack.empty()) {
					return;
				}
				p = stack.pop();
			}
			// 处理右子,当前节点入栈,处理右子树
			stack.push(p);
			p = p.getRight();
		}
	}
	
	/**
	 * 非递归实现后序遍历2 单栈法
	 * 对于任一结点P，
	 * 1）将其入栈，然后沿其左子树一直往下搜索入栈，直到搜索到没有左孩子的结点，
	 * 此时该结点出现在栈顶，但是此时不能将其出栈并访问，因此其右孩子还未被访问。
	 * 所以接下来按照相同的规则对其右子树进行相同的处理，当访问完其右孩子时，该结点又出现在栈顶， 此时可以将其出栈并访问。这样就保证了正确的访问顺序。
	 * 可以看出，在这个过程中，每个结点都两次出现在栈顶，只有在第二次出现在栈顶时，才能访问它。 因此需要多设置一个变量标识该结点是否是第一次出现在栈顶。
	 * 
	 * @param p
	 */
	public void postOrder2(TreeNode p) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p, prev = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				TreeNode temp = stack.peek().getRight();
				if (temp == null || temp == prev) {
					node = stack.pop();
					visit(node);
					prev = node;
					node = null;
				} else {
					node = temp;
				}
			}
		}
	}

	/**
	 * 非递归实现后序遍历3
	 * 1)对于任一结点P，先将其入栈。
	 * 2)如果P不存在左孩子和右孩子，则可以直接访问它；
	 * 3)如果P存在左孩子或者右孩子，但是其左孩子或右孩子都已被访问过了，则同样可以直接访问该结点。
	 * 4)若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，
	 * 保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问
	 * @param p
	 */
	public void postOrder3(TreeNode p) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node,prev = p;
		stack.push(p);
		while (!stack.isEmpty()) {
			//取栈顶元素，但不弹出
			node = stack.peek();
			//如果左孩子和右孩子都为空||其左孩子或右孩子都已被访问过了
			if ((node.getLeft() == null && node.getRight() == null)|| 
				(prev == node.getLeft() || prev == node.getRight())) {
				visit(node);
				stack.pop();
				prev = node;
			} else {
				//将P的右孩子和左孩子依次入栈
				if (node.getRight() != null) {
					stack.push(node.getRight());
				}
				if (node.getLeft() != null) {
					stack.push(node.getLeft());
				}
			}
		}
	}

	/**
	 * 非递归实现后序遍历 3 双栈法
	 * 
	 * @param p
	 */
	public void postOrder4(TreeNode p) {

		Stack<TreeNode> lstack = new Stack<TreeNode>();// 左子树栈
		Stack<TreeNode> rstack = new Stack<TreeNode>();// 右子树栈
		TreeNode node = p, right;
		do {
			while (node != null) {
				right = node.getRight();
				lstack.push(node);
				rstack.push(right);
				node = node.getLeft();
			}
			node = lstack.pop();
			right = rstack.pop();
			if (right == null) {
				visit(node);
			} else {
				lstack.push(node);
				rstack.push(null);
			}
			node = right;
		} while (lstack.size() > 0 || rstack.size() > 0);
	}

	/**
	 * 非递归实现后序遍历4 双栈法
	 * 
	 * @param p
	 */
	public void postOrder5(TreeNode p) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> temp = new Stack<TreeNode>();
		TreeNode node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				temp.push(node);
				stack.push(node);
				node = node.getRight();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				node = node.getLeft();
			}
		}
		while (temp.size() > 0) {// 把插入序列都插入到了temp。
			node = temp.pop();
			visit(node);
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
			visit(tn);
			if (tn.getLeft() != null) {
				arr.add(tn.getLeft());
			}
			if (tn.getRight() != null) {
				arr.add(tn.getRight());
			}
		}
	}
}

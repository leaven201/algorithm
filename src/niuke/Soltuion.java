package niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Soltuion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// p1
		// problem1 p1=new problem1();
		// int[] array= {3,4,5,1,2};
		// System.out.println(p1.minNumberInRotateArray(array));
		// p2
		// problem2 p2=new problem2();
		// double result=p2.Power(3,5);
		// System.out.println(result);
		// p3
		// int[][] array = { { 1, 2, 3, 4, }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13,
		// 14, 15, 16 } };
		// int[][] array1 = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
		// int[][] array2= {{1,2,3,4,5}};
		// problem9 p9 = new problem9();
		// // p9.printArray(array);
		// // p9.printArray(p9.subMatrix(array));
		// // System.out.println(p9.printMatrix(array));
		// System.out.println(p9.printMatrix(array2));

		// problem10 p10=new problem10();
		// p10.push(3);
		// System.out.println(p10.min());
		// p10.push(4);
		// System.out.println(p10.min());
		// p10.push(2);
		// System.out.println(p10.min());
		// p10.push(1);
		// System.out.println(p10.min());
		// p10.pop();
		// System.out.println(p10.min());
		// p10.pop();
		// System.out.println(p10.min());
		// p10.push(0);
		// System.out.println(p10.min());

		// problem12 p12 = new problem12();
		// TreeNode node1 = new TreeNode(1);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node4 = new TreeNode(4);
		// TreeNode node5 = new TreeNode(5);
		// TreeNode node6 = new TreeNode(6);
		// TreeNode node7 = new TreeNode(7);
		// TreeNode node8 = new TreeNode(8);
		// TreeNode node9 = new TreeNode(9);
		// TreeNode node10 = new TreeNode(10);
		// node1.left = node2;
		// node1.right = node3;
		// node2.left = node4;
		// node2.right = node5;
		// node3.left = node6;
		// node4.left = node7;
		// node5.right = node8;
		// node6.left = node9;
		// node6.right = node10;
		// TreeNode node1 = null;
		// System.err.println(p12.PrintFromTopToBottom(node1));

		// problem14 p14 = new problem14();
		// TreeNode node1 = new TreeNode(10);
		// TreeNode node2 = new TreeNode(5);
		// TreeNode node3 = new TreeNode(12);
		// TreeNode node4 = new TreeNode(4);
		// TreeNode node5 = new TreeNode(7);
		// node1.left = node2;
		// node1.right = node3;
		// node2.left = node4;
		// node2.right = node5;
		// ArrayList<ArrayList<Integer>> allPath = p14.FindPath(node1, 22);
		// System.out.println(allPath);

		int[] array = { 1, 2, 2, 2, 2, };
		problem15 p15 = new problem15();
		System.out.println(p15.MoreThanHalfNum_Solution(array));

	}

}

/*
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

class problem1 {
	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0)
			return 0;
		else {
			int index1 = 0;
			int index2 = array.length;
			while (index1 != index2 && index1 + 1 != index2) {
				if (array[(index1 + index2) / 2] >= array[index1])
					index1 = (index1 + index2) / 2;
				else
					index2 = (index1 + index2) / 2;
			}
			return array[index2];
		}
	}
}

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 */
class problem2 {
	boolean invalidInput = false;

	public double Power(double base, int exponent) {
		// 判断输入是否符合数学性
		if (base == 0 && exponent < 0) {
			invalidInput = true;
			return 0.0;
		}
		int absOfExponent = Math.abs(exponent);

		double result = PowerWithUnsignedExponent(base, absOfExponent);
		if (exponent < 0)
			return 1 / result;
		return result;

	}

	private double PowerWithUnsignedExponent(double base, int absOfExponent) {
		if (absOfExponent == 0)
			return 1;
		if (absOfExponent == 1)
			return base;
		// 用右移(>>)1位代替除2，提高效率 利用迭代提高
		double result = PowerWithUnsignedExponent(base, absOfExponent >> 1);
		result *= base;
		// 与1进行位与运算判断奇偶，提高效率
		if ((absOfExponent & 1) == 1)
			result *= base;
		return result;
	}
}

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分， 所有的偶数位于位于数组的后半部分.
 **/

class problem3 {
	public void reOrderArray1(int[] array) {
		if (array.length > 1) {
			int star = 0;
			int end = array.length - 1;
			while (star < end) {
				// 向后移动star,star指向奇数并且star＜end
				while ((array[star] & 1) == 1 && star < end) {
					star++;
				}
				// 向前移动end，end指向偶数并且star<end
				while ((array[end] & 1) == 0 && star < end) {
					end--;
				}
				// 交换
				if (star < end) {
					int temp = array[star];
					array[star] = array[end];
					array[end] = temp;
				}
			}
		}
	}
}

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 **/
class problem3_1 {
	public void reOrderArray1(int[] array) {
		ArrayList<Integer> ji = new ArrayList<>();
		ArrayList<Integer> ou = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			// 为偶数
			if ((array[i] & 1) == 1)
				ji.add(array[i]);
			// 为偶数
			if ((array[i] & 1) == 0)
				ou.add(array[i]);
		}
		ji.addAll(ou);
		Object[] he = ji.toArray();
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) he[i];
		}
	}
}

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

class problem4 {
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null)
			return null;
		ListNode node = head;
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		ListNode p = head;
		if (k > count)
			return null;
		for (int i = 0; i < count - k; i++) {
			p = p.next;
		}
		return p;
	}
}

class problem4_1 {
	public ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k <= 0)
			return null;
		ListNode p1 = head;
		ListNode p2 = head;
		// p2先向前走k-1步
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null)
				return null;
			p2 = p2.next;
		}
		if (p2 == null)
			return null;
		// p2走到底，p1开始走
		while (p2.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}
}

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
// 利用递归法
class problem5 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null && list2 != null)
			return list2;
		if (list2 == null && list1 != null)
			return list1;
		if (list1 == null && list2 == null)
			return null;
		if (list1.val <= list2.val) {
			list1.next = Merge(list1.next, list2);
			return list1;
		} else {
			list2.next = Merge(list1, list2.next);
			return list2;
		}
	}
}

// 非递归方法
class problem5_1 {
	public ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null && list2 != null)
			return list2;
		if (list2 == null && list1 != null)
			return list1;
		if (list1 == null && list2 == null)
			return null;
		ListNode mergeHead = null;
		ListNode current = null;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				if (mergeHead == null) {
					mergeHead = current = list1;
				} else {
					current.next = list1;
					current = current.next;
				}
				list1 = list1.next;
			} else {
				if (mergeHead == null) {
					mergeHead = current = list2;
				} else {
					current.next = list2;
					current = current.next;
				}
				list2 = list2.next;
			}
		}
		if (list1 == null) {
			current.next = list2;
		} else {
			current.next = list1;
		}
		return mergeHead;
	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

class problem6 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		// 如果两个树有任一个是空就跳出false
		if (root2 == null || root1 == null)
			return false;

		boolean result = false;
		if (root1 != null && root2 != null) {
			// 从根节点开始如果两个根节点值相等就进入DoesTree1HaveTree2()方法，判断root2是不是root1的子结构
			if (Equal(root1.val, root2.val))
				result = DoesTree1HaveTree2(root1, root2);

			// 如果上面判断以root1为根节点不存在root2的子树，则从root1的左右节点各为新的根节点，通过递归完成判断
			if (!result)
				result = HasSubtree(root1.left, root2);
			if (!result)
				result = HasSubtree(root1.right, root2);
		}
		return result;
	}

	private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
		// root2遍历完成，到了null，说明root2是root1的子结构
		if (root2 == null)
			return true;
		// root1遍历完了，说明在root1中找不到root2的子结构
		if (root1 == null)
			return false;
		// 节点的值不等，立刻跳出false，说明以此（传入的参数root1）root1为根节点出发找的子树不是root2
		// 跳出false后返回HasSubtree(root1.left, root2),HasSubtree(root1.right, root2)
		// 从root1的左右节点再去迭代找
		if (!Equal(root1.val, root2.val))
			return false;
		// 如果Equal(root1.val, root2.val)成立，则再去判断root1和root2的左右节点是否一样
		// 如果一直一样，最终root2会遍历完，说明找到了子结构
		// 如果不一样，就去找root1的子节点，root1遍历完都还没找到说明root1不含root2的子结构
		return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);

	}

	// 由于计算机表示小数（包括float和double型小数）都有误差，我们不能直接用等号（==）判断两个小数是否相等。
	// 如果两个小数的差的绝对值很小，如小于0.0000001，就可以人文他们相等。
	private boolean Equal(double d1, double d2) {
		if ((d1 - d2 > -0.0000001) && (d1 - d2 < 0.0000001))
			return true;
		else
			return false;
	}
}

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 **/

class problem7 {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null) {
			return null;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}

		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}

	// 前序 开始索引 结束索引 中序 开始索引 结束索引 存储中序序列的hashmap
	public TreeNode preIn(int[] p, int pk, int pj, int[] n, int ik, int ij, HashMap<Integer, Integer> map) {
		// 前序（中序）开始索引大于结束索引，说明完成了遍历，返回空 既结束
		if (pk > pj || ik > ij) {
			return null;
		}
		TreeNode head = new TreeNode(p[pk]);
		int index = map.get(p[pk]);
		head.left = preIn(p, pk + 1, pk + index - ik, n, ik, index - 1, map);
		head.right = preIn(p, pk + index - ik + 1, pj, n, index + 1, ij, map);
		return head;
		// if (pk > pj) {
		// return null;
		// }
		// TreeNode head = new TreeNode(p[pk]);//根据p[pi]前序遍历序列的第一个新建一个（子）根节点
		// int index = map.get(p[pk]); //在中序遍历序列中找出相应的值，返回其所在的位置
		// //pk+index-ik: 中序表中index-ik为左子树有几个，
		// 前序总，左子树开始索引为pk+1，因为pk是根节点，从pk+1到pk+index-ik正好有index-ik个
		// head.left = preIn(p, pk + 1, pk+index-ik, n, ik, index - 1, map);
		// head.right = preIn(p, pk+index-ik + 1, pj, n, index + 1, ij, map);
		// return head;
	}
}

/*
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
class problem8 {
	public void Mirror(TreeNode root) {
		if (root == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);

	}
}

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
class problem9 {
	ArrayList<Integer> printList = new ArrayList<>();

	public ArrayList<Integer> printMatrix(int[][] matrix) {

		if (matrix != null) {
			printList.addAll(printOut(matrix));
			printMatrix(subMatrix(matrix));
		}
		return printList;
	}

	// 由n*n矩阵得到(n-2)*(n-2)矩阵
	public int[][] subMatrix(int[][] matr) {
		if (matr.length > 2 && matr[0].length > 2) {
			int[][] submat = new int[matr.length - 2][matr[0].length - 2];
			for (int i = 1; i < matr.length - 1; i++) {
				for (int j = 1; j < matr[0].length - 1; j++) {
					submat[i - 1][j - 1] = matr[i][j];
				}
			}
			return submat;
		}
		return null;
	}

	// 顺时针打印矩阵的最外圈
	public ArrayList<Integer> printOut(int[][] matrix) {
		ArrayList<Integer> printList = new ArrayList<>();
		// 打印第一行,行为0列++
		for (int i = 0; i < matrix[0].length; i++) {
			printList.add(matrix[0][i]);
		}
		// 打印最右列，行++列为matrix[0].length-1
		for (int i = 1; i < matrix.length; i++) {
			printList.add(matrix[i][matrix[0].length - 1]);
		}
		// 打印最后一行，行为matrix.length-1，列--;前提：行数大于1
		if (matrix.length > 1) {
			for (int i = (matrix[0].length - 2); i >= 0; i--) {
				printList.add(matrix[matrix.length - 1][i]);
			}
		}
		// 打印第一列，行--列为0;前提：列数大于1
		if (matrix[0].length > 1) {
			for (int i = matrix.length - 2; i > 0; i--) {
				printList.add(matrix[i][0]);
			}
		}
		return printList;
	}

	// 打印一个矩阵
	public void printArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.println(matrix[i][j]);
		}
	}
}

/*
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
class problem10 {
	Stack<Integer> dataStack = new Stack<>();// 数据栈
	Stack<Integer> supStack = new Stack<>();// 辅助栈

	public void push(int node) {
		// 首先将该值压入数据栈
		dataStack.push(node);
		// 将该值与最小值比较判断是否将该值压入辅助栈，如果node小于最小值，node加入辅助栈，如果否最小值加入辅助栈
		if (supStack.isEmpty())
			supStack.push(node);
		else {
			if (node < min())
				supStack.push(node);
			else
				supStack.push(min());
		}
	}

	public void pop() {
		if (dataStack.size() != 0 && supStack.size() != 0) {
			// 数据栈出栈
			dataStack.pop();
			// 辅助栈出栈
			supStack.pop();
		}
	}

	public int top() {
		return dataStack.peek();
	}

	// 最小值即为辅助栈栈顶元素
	public int min() {
		return supStack.peek();
	}
}

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（ 注意：这两个序列的长度是相等的）
 */

/*
 * 思路：如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；如果下一个弹出数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，
 * 直到把下一个需要弹出的数字压入栈顶为止，如果所有的数字都压入栈仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列
 */

class problem11 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || popA.length != pushA.length)
			return false;
		// 辅助栈
		Stack<Integer> sta = new Stack<>();
		// 用于标识弹出序列的位置
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			sta.push(pushA[i]);
			// 如果栈不为空，且栈顶元素等于弹出序列
			while (!sta.isEmpty() && sta.peek() == popA[popIndex]) {
				// 辅助栈弹出栈顶元素
				sta.pop();
				// 弹出序列后移一位
				popIndex++;
			}
		}
		// 依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。
		return sta.isEmpty();
	}
}

/*
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。 思路:利用队列做容器
 */

class problem12 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		if (root == null)
			return list;
		// 将root插入队列
		que.offer(root);
		// 如果队列不为空就{....}
		while (!que.isEmpty()) {
			// 队头出队
			TreeNode node = que.poll();
			// 如果node有左右节点就将其加入队列
			if (node.left != null)
				que.offer(node.left);
			if (node.right != null)
				que.offer(node.right);
			// 将node的值加入list
			list.add(node.val);
		}
		return list;
	}
}

/*
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

/*
 * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
 * 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x， 后一段（右子树）大于x，且这两段（子树）都是合法的后序序列
 */

/*
 * 思路：递归
 */

class problem13 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0)
			return false;
		return subVerify(sequence, 0, sequence.length - 1);
	}

	public boolean subVerify(int[] seq, int start, int end) {
		if (end <= start)
			return true;
		// 利用该方法的循环可以把循环内的局部变量i变为全局的，方便后面调用int i=start for(;i<end;i++){}
		int i = start;
		// 从序列的第一个开始找，找到比根节点大的元素后跳出该循环体
		for (; i < end; i++) {
			if (seq[i] > seq[end])
				break;
		}

		// 从上面比根节点大的元素开始找，如果找到比根节点小的元素就返回false
		for (int j = i; j < end; j++) {
			if (seq[j] < seq[end])
				return false;
		}
		// 迭代判断序列的左子树序列和右子树序列是否满足后序遍历的要求
		// 左子树序列1 右子树序列2
		return (subVerify(seq, start, i - 1) && subVerify(seq, i, end - 1));
	}
}

/*
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
class problem14 {
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> allPath = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return allPath;
		ArrayList<Integer> path = new ArrayList<>();
		int currentSum = 0;
		FindPath(root, target, currentSum, path, allPath);
		return allPath;
	}

	public void FindPath(TreeNode root, int target, int currentSum, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> allPath) {
		if (root == null)
			return;
		currentSum += root.val;// 计算当前路径的和
		// 如果当前节点是叶节点，并且路径和等于target，则将该路径path加入allPath
		if (root.left == null && root.right == null) {
			if (currentSum == target) {
				path.add(root.val);
				allPath.add(new ArrayList<Integer>(path));
				// 这样会有错误,因为这只是将这一个path的指引加入allPath，后面path变的时候allPath里的path也在变，因此需要新建
				// allPath.add(path);
				path.remove(path.size() - 1);
			}
			return;
		}
		path.add(root.val);
		System.out.println(path);
		FindPath(root.left, target, currentSum, path, allPath);
		// 如果root.left==null；则会return然后进行下一步FindPath（root.right....）
		FindPath(root.right, target, currentSum, path, allPath);
		// 如果root.right==null，则需要返回到root，并且在path中要删掉path的最后一个
		path.remove(path.size() - 1);
	}
}

/*
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
class problem15 {
	public int MoreThanHalfNum_Solution(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			int sum = 1;
			// 如果array[i]键没有对应的值得映射关系，则将键：array[i]值：1，表示array[i]数量为1
			if (map.get(array[i]) == null) {
				map.put(array[i], sum);
			} else {
				// 如果已有映射关系了，则修改array[i]对应的键值映射关系，将值+1，表示array[i]数量
				sum = map.get(array[i]) + 1;
				map.put(array[i], sum);
			}
			// 如果array[i]键对应的值大于array.length/2，说明array[i]出现次数大于数组的一半，则将其输出
			if (sum > (array.length / 2))
				return array[i];
		}
		return 0;
	}
}

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

class problem16 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
		ArrayList<Integer> list=new ArrayList<>();
		if(k>input.length)
			return list;
		//sort()方法将数组按升序排序
		Arrays.sort(input);
		for(int i=0;i<k;i++) {
			list.add(input[i]);
		}
		return list;
	}
}


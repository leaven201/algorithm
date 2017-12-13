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
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
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
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 *
 */
class problem2 {
	boolean invalidInput = false;

	public double Power(double base, int exponent) {
		// �ж������Ƿ������ѧ��
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
		// ������(>>)1λ�����2�����Ч�� ���õ������
		double result = PowerWithUnsignedExponent(base, absOfExponent >> 1);
		result *= base;
		// ��1����λ�������ж���ż�����Ч��
		if ((absOfExponent & 1) == 1)
			result *= base;
		return result;
	}
}

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣� ���е�ż��λ��λ������ĺ�벿��.
 **/

class problem3 {
	public void reOrderArray1(int[] array) {
		if (array.length > 1) {
			int star = 0;
			int end = array.length - 1;
			while (star < end) {
				// ����ƶ�star,starָ����������star��end
				while ((array[star] & 1) == 1 && star < end) {
					star++;
				}
				// ��ǰ�ƶ�end��endָ��ż������star<end
				while ((array[end] & 1) == 0 && star < end) {
					end--;
				}
				// ����
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
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 **/
class problem3_1 {
	public void reOrderArray1(int[] array) {
		ArrayList<Integer> ji = new ArrayList<>();
		ArrayList<Integer> ou = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			// Ϊż��
			if ((array[i] & 1) == 1)
				ji.add(array[i]);
			// Ϊż��
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
 * ����һ����������������е�����k����㡣
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
		// p2����ǰ��k-1��
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null)
				return null;
			p2 = p2.next;
		}
		if (p2 == null)
			return null;
		// p2�ߵ��ף�p1��ʼ��
		while (p2.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}
}

/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 */
// ���õݹ鷨
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

// �ǵݹ鷽��
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
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 */

class problem6 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		// �������������һ���ǿվ�����false
		if (root2 == null || root1 == null)
			return false;

		boolean result = false;
		if (root1 != null && root2 != null) {
			// �Ӹ��ڵ㿪ʼ����������ڵ�ֵ��Ⱦͽ���DoesTree1HaveTree2()�������ж�root2�ǲ���root1���ӽṹ
			if (Equal(root1.val, root2.val))
				result = DoesTree1HaveTree2(root1, root2);

			// ��������ж���root1Ϊ���ڵ㲻����root2�����������root1�����ҽڵ��Ϊ�µĸ��ڵ㣬ͨ���ݹ�����ж�
			if (!result)
				result = HasSubtree(root1.left, root2);
			if (!result)
				result = HasSubtree(root1.right, root2);
		}
		return result;
	}

	private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
		// root2������ɣ�����null��˵��root2��root1���ӽṹ
		if (root2 == null)
			return true;
		// root1�������ˣ�˵����root1���Ҳ���root2���ӽṹ
		if (root1 == null)
			return false;
		// �ڵ��ֵ���ȣ���������false��˵���Դˣ�����Ĳ���root1��root1Ϊ���ڵ�����ҵ���������root2
		// ����false�󷵻�HasSubtree(root1.left, root2),HasSubtree(root1.right, root2)
		// ��root1�����ҽڵ���ȥ������
		if (!Equal(root1.val, root2.val))
			return false;
		// ���Equal(root1.val, root2.val)����������ȥ�ж�root1��root2�����ҽڵ��Ƿ�һ��
		// ���һֱһ��������root2������꣬˵���ҵ����ӽṹ
		// �����һ������ȥ��root1���ӽڵ㣬root1�����궼��û�ҵ�˵��root1����root2���ӽṹ
		return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);

	}

	// ���ڼ������ʾС��������float��double��С�������������ǲ���ֱ���õȺţ�==���ж�����С���Ƿ���ȡ�
	// �������С���Ĳ�ľ���ֵ��С����С��0.0000001���Ϳ�������������ȡ�
	private boolean Equal(double d1, double d2) {
		if ((d1 - d2 > -0.0000001) && (d1 - d2 < 0.0000001))
			return true;
		else
			return false;
	}
}

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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

	// ǰ�� ��ʼ���� �������� ���� ��ʼ���� �������� �洢�������е�hashmap
	public TreeNode preIn(int[] p, int pk, int pj, int[] n, int ik, int ij, HashMap<Integer, Integer> map) {
		// ǰ�����򣩿�ʼ�������ڽ���������˵������˱��������ؿ� �Ƚ���
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
		// TreeNode head = new TreeNode(p[pk]);//����p[pi]ǰ��������еĵ�һ���½�һ�����ӣ����ڵ�
		// int index = map.get(p[pk]); //����������������ҳ���Ӧ��ֵ�����������ڵ�λ��
		// //pk+index-ik: �������index-ikΪ�������м�����
		// ǰ���ܣ���������ʼ����Ϊpk+1����Ϊpk�Ǹ��ڵ㣬��pk+1��pk+index-ik������index-ik��
		// head.left = preIn(p, pk + 1, pk+index-ik, n, ik, index - 1, map);
		// head.right = preIn(p, pk+index-ik + 1, pj, n, index + 1, ij, map);
		// return head;
	}
}

/*
 * ���������Ķ�����������任ΪԴ�������ľ���
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
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
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

	// ��n*n����õ�(n-2)*(n-2)����
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

	// ˳ʱ���ӡ���������Ȧ
	public ArrayList<Integer> printOut(int[][] matrix) {
		ArrayList<Integer> printList = new ArrayList<>();
		// ��ӡ��һ��,��Ϊ0��++
		for (int i = 0; i < matrix[0].length; i++) {
			printList.add(matrix[0][i]);
		}
		// ��ӡ�����У���++��Ϊmatrix[0].length-1
		for (int i = 1; i < matrix.length; i++) {
			printList.add(matrix[i][matrix[0].length - 1]);
		}
		// ��ӡ���һ�У���Ϊmatrix.length-1����--;ǰ�᣺��������1
		if (matrix.length > 1) {
			for (int i = (matrix[0].length - 2); i >= 0; i--) {
				printList.add(matrix[matrix.length - 1][i]);
			}
		}
		// ��ӡ��һ�У���--��Ϊ0;ǰ�᣺��������1
		if (matrix[0].length > 1) {
			for (int i = matrix.length - 2; i > 0; i--) {
				printList.add(matrix[i][0]);
			}
		}
		return printList;
	}

	// ��ӡһ������
	public void printArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.println(matrix[i][j]);
		}
	}
}

/*
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 */
class problem10 {
	Stack<Integer> dataStack = new Stack<>();// ����ջ
	Stack<Integer> supStack = new Stack<>();// ����ջ

	public void push(int node) {
		// ���Ƚ���ֵѹ������ջ
		dataStack.push(node);
		// ����ֵ����Сֵ�Ƚ��ж��Ƿ񽫸�ֵѹ�븨��ջ�����nodeС����Сֵ��node���븨��ջ���������Сֵ���븨��ջ
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
			// ����ջ��ջ
			dataStack.pop();
			// ����ջ��ջ
			supStack.pop();
		}
	}

	public int top() {
		return dataStack.peek();
	}

	// ��Сֵ��Ϊ����ջջ��Ԫ��
	public int min() {
		return supStack.peek();
	}
}

/*
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
 * ����4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С��� ע�⣺���������еĳ�������ȵģ�
 */

/*
 * ˼·�������һ�����������ָպ���ջ�����֣���ôֱ�ӵ����������һ���������ֲ���ջ�������ѹջ�����л�û����ջ������ѹ�븨��ջ��
 * ֱ������һ����Ҫ����������ѹ��ջ��Ϊֹ��������е����ֶ�ѹ��ջ��Ȼû���ҵ���һ�����������֣���ô�����в�������һ����������
 */

class problem11 {
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || popA.length != pushA.length)
			return false;
		// ����ջ
		Stack<Integer> sta = new Stack<>();
		// ���ڱ�ʶ�������е�λ��
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			sta.push(pushA[i]);
			// ���ջ��Ϊ�գ���ջ��Ԫ�ص��ڵ�������
			while (!sta.isEmpty() && sta.peek() == popA[popIndex]) {
				// ����ջ����ջ��Ԫ��
				sta.pop();
				// �������к���һλ
				popIndex++;
			}
		}
		// ����ִ�У������ջΪ�ա������Ϊ��˵���������в��Ǹ�ջ�ĵ���˳��
		return sta.isEmpty();
	}
}

/*
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ�� ˼·:���ö���������
 */

class problem12 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		if (root == null)
			return list;
		// ��root�������
		que.offer(root);
		// ������в�Ϊ�վ�{....}
		while (!que.isEmpty()) {
			// ��ͷ����
			TreeNode node = que.poll();
			// ���node�����ҽڵ�ͽ���������
			if (node.left != null)
				que.offer(node.left);
			if (node.right != null)
				que.offer(node.right);
			// ��node��ֵ����list
			list.add(node.val);
		}
		return list;
	}
}

/*
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ���� ����������Yes,�������No���������������������������ֶ�������ͬ��
 */

/*
 * BST�ĺ������еĺϷ������ǣ�����һ������S�����һ��Ԫ����x ��Ҳ���Ǹ�����
 * ���ȥ�����һ��Ԫ�ص�����ΪT����ôT���㣺T���Էֳ����Σ�ǰһ�Σ���������С��x�� ��һ�Σ�������������x���������Σ����������ǺϷ��ĺ�������
 */

/*
 * ˼·���ݹ�
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
		// ���ø÷�����ѭ�����԰�ѭ���ڵľֲ�����i��Ϊȫ�ֵģ�����������int i=start for(;i<end;i++){}
		int i = start;
		// �����еĵ�һ����ʼ�ң��ҵ��ȸ��ڵ���Ԫ�غ�������ѭ����
		for (; i < end; i++) {
			if (seq[i] > seq[end])
				break;
		}

		// ������ȸ��ڵ���Ԫ�ؿ�ʼ�ң�����ҵ��ȸ��ڵ�С��Ԫ�ؾͷ���false
		for (int j = i; j < end; j++) {
			if (seq[j] < seq[end])
				return false;
		}
		// �����ж����е����������к������������Ƿ�������������Ҫ��
		// ����������1 ����������2
		return (subVerify(seq, start, i - 1) && subVerify(seq, i, end - 1));
	}
}

/*
 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·���� ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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
		currentSum += root.val;// ���㵱ǰ·���ĺ�
		// �����ǰ�ڵ���Ҷ�ڵ㣬����·���͵���target���򽫸�·��path����allPath
		if (root.left == null && root.right == null) {
			if (currentSum == target) {
				path.add(root.val);
				allPath.add(new ArrayList<Integer>(path));
				// �������д���,��Ϊ��ֻ�ǽ���һ��path��ָ������allPath������path���ʱ��allPath���pathҲ�ڱ䣬�����Ҫ�½�
				// allPath.add(path);
				path.remove(path.size() - 1);
			}
			return;
		}
		path.add(root.val);
		System.out.println(path);
		FindPath(root.left, target, currentSum, path, allPath);
		// ���root.left==null�����returnȻ�������һ��FindPath��root.right....��
		FindPath(root.right, target, currentSum, path, allPath);
		// ���root.right==null������Ҫ���ص�root��������path��Ҫɾ��path�����һ��
		path.remove(path.size() - 1);
	}
}

/*
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
class problem15 {
	public int MoreThanHalfNum_Solution(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			int sum = 1;
			// ���array[i]��û�ж�Ӧ��ֵ��ӳ���ϵ���򽫼���array[i]ֵ��1����ʾarray[i]����Ϊ1
			if (map.get(array[i]) == null) {
				map.put(array[i], sum);
			} else {
				// �������ӳ���ϵ�ˣ����޸�array[i]��Ӧ�ļ�ֵӳ���ϵ����ֵ+1����ʾarray[i]����
				sum = map.get(array[i]) + 1;
				map.put(array[i], sum);
			}
			// ���array[i]����Ӧ��ֵ����array.length/2��˵��array[i]���ִ������������һ�룬�������
			if (sum > (array.length / 2))
				return array[i];
		}
		return 0;
	}
}

/**
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 */

class problem16 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
		ArrayList<Integer> list=new ArrayList<>();
		if(k>input.length)
			return list;
		//sort()���������鰴��������
		Arrays.sort(input);
		for(int i=0;i<k;i++) {
			list.add(input[i]);
		}
		return list;
	}
}


package medium;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/*
 * 题目：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
class StackAndQueue{
	
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
	
	//实现一个元素入队
	public void push(int node) {
		stack1.push(node);
	}
	//实现一个元素的出队列
	public int pop() {
		while(!stack1.isEmpty()) {                  //如果stack1不为空，则将stack1的元素全部压入stack2
			stack2.push(stack1.pop());
		}
		int x1=stack2.pop();                       //输出此时stack2的栈顶元素即为最早输入的元素
		
		while(!stack2.isEmpty()) {                 //将其余元素重新压回stack1
			stack1.push(stack2.pop());
		}
	    return x1;	
	}
}

package medium;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/*
 * ��Ŀ��������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
class StackAndQueue{
	
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
	
	//ʵ��һ��Ԫ�����
	public void push(int node) {
		stack1.push(node);
	}
	//ʵ��һ��Ԫ�صĳ�����
	public int pop() {
		while(!stack1.isEmpty()) {                  //���stack1��Ϊ�գ���stack1��Ԫ��ȫ��ѹ��stack2
			stack2.push(stack1.pop());
		}
		int x1=stack2.pop();                       //�����ʱstack2��ջ��Ԫ�ؼ�Ϊ���������Ԫ��
		
		while(!stack2.isEmpty()) {                 //������Ԫ������ѹ��stack1
			stack1.push(stack2.pop());
		}
	    return x1;	
	}
}

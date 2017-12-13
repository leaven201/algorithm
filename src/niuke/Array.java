package niuke;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		Solution s = new Solution();
		System.out.println(s.Find(7, array));

	}

}

/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * 
 * ˼·���������Ͻǵ�Ԫ�أ������Ԫ�ش���target��ɾ������(column--)������һ�¸����Ͻ� 
 *                 �����Ԫ��С��target��ɾ������(row++)��������һ�����Ͻ�
 *                 �����Ԫ�ص���target�����return��true ������������return��false
 */

class Solution {
	public boolean Find(int target, int[][] array) {
		int row=0;
		int column=array[0].length-1;
		return Find(target, array, row, column);		
	}
	public boolean Find(int target,int[][] array,int row,int column) {
		if(row>array.length-1||column<0)
			return false;
		if(array[row][column]==target){
			return true;
		}
		else if(array[row][column]>target) {
			column--;
			return Find(target, array, row, column);
		}
		else {
			row++;
			return Find(target, array, row, column);
		}
	}
}




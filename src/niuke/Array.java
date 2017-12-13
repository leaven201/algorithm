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
 * ˼·���������Ͻǵ�Ԫ�أ������Ԫ�ش���target��ɾ�����У�����һ�¸����Ͻ� �����Ԫ��С��target��ɾ�����У�������һ�����Ͻ�
 * �����Ԫ�ص���target�����return��true ������������return��false
 */

class Solution {
	public boolean Find(int target, int[][] array) {
		// �ж϶�ά�����Ƿ�Ϊ��
		// һ�������׵�ַ�Ƿ�Ϊ��
		// �����Ƿ�Ϊ{}��Ҳ����array.length==0�����
		// ����{{}}����ʱarray.length=1������array[0].length==0����������һ�������Ϳ��Է���false�ˡ�
		if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0))
			return false;
		int row = array.length;
		int column = array[0].length;
		return Find(target, array, row, column);
	}

	public boolean Find(int target, int[][] array, int row, int column) {
		// �ж϶�ά�����Ƿ�Ϊ��
		// һ�������׵�ַ�Ƿ�Ϊ��
		// �����Ƿ�Ϊ{}��Ҳ����array.length==0�����
		// ����{{}}����ʱarray.length=1������array[0].length==0����������һ�������Ϳ��Է���false�ˡ�
		if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0))
			return false;
		else {
			int current = array[0][column];// ���Ͻ�Ԫ��
			if (current == target)
				return true;
			if (current > target) {
				column--;
				Find(target, array, row, column);
			}
			if (current < target) {
				row--;
				Find(target, array, row, column);
			}
		}
		return false;
	}
}
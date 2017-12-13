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
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 思路：找最右上角的元素，如果该元素大于target则删除该列(column--)，再找一下个右上角 
 *                 如果该元素小于target则删除改行(row++)，再找下一个右上角
 *                 如果该元素等于target则结束return：true 如果矩阵空了则return：false
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




package palindrome;
public class isPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test1=new Solution();
		System.out.println(test1.isPalindrome(1233321));

	}

}


class Solution{
	public boolean isPalindrome(int x) {
		if(x<0)
			return false;
		else {			
		int z=Math.abs(x);
		int y=0;
		while(z!=0) {
		    y=y*10+z%10;
			z=z/10;
		}
		if(y==Math.abs(x))
			return true;
		else
			return false;
	}}
}
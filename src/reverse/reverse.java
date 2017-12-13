package reverse;

public class reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s1=new Solution();
		int rx=s1.reverse(1534236469);
		System.out.println(rx);


	}

}

class Solution{
	public int reverse(int x) {
		if(x>=0) {
			if(x>(Integer.MAX_VALUE)/2)
				return 0;
			else
			{
				int y=0;
				while((x/10)!=0) {
					y=y*10+x%10;
					x=x/10;
				}return y*10+x%10;
			}
		}else {
			if(x<(Integer.MIN_VALUE)/2)
				return 0;
			else {
				int rx=-x;
				int y=0;
				while((rx/10)!=0) {
					y=y*10+rx%10;
					rx=rx/10;
				}return -(y*10+rx%10);
			}
		}
	}
	
}

package easy;

public class CommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s1=new Solution();
		String[] strs= {"abcde","abc","abcjkkdf"};
        System.out.println(s1.longestCommonPrefix(strs));
		

	}

}

class Solution{
	public String longestCommonPrefix(String[] strs) {
	    if(strs.length==0)
	    	return "";
	    String prefix=strs[0];
	    for(int i=0;i<strs.length;i++)
	    	while(strs[i].indexOf(prefix)!=0) {
	    		prefix=prefix.substring(0, prefix.length()-1);
	    		if(prefix=="")
	    			return "";
	    	}
	    return prefix;
	}
}

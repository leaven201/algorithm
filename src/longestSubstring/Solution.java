package longestSubstring;

import java.util.*;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j <= n; j++)
				if (allUnique(s, i, j))
					{ans = Math.max(ans, j - i);System.out.println(ans);}
		return ans;
	}

	public boolean allUnique(String s, int start, int end) {// we check if the set already contains it.
															// If so, we return false. After the loop, we return true.
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}

	public static void main(String[] arge) {
		Solution a = new Solution();
		System.out.println(a.lengthOfLongestSubstring("qwe"));
	}

}

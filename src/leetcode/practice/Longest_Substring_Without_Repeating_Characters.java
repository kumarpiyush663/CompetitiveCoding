package leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {

	
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n<2) return n;
        int res = 1;
        Map<Character, Integer> m = new HashMap<>();
        
        int j = 0;
        int i = 0;        
        while(j<n){
            if (m.containsKey(s.charAt(j))) {
                i = Math.max(m.get(s.charAt(j)), i);
            }
            res = Math.max(res,j-i+1);
             m.put(s.charAt(j), j + 1);
             j++;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcbb"; //ans :-  3
		
		System.out.println(new Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring(s));

	}

}

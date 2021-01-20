/*
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false


Example 4:
Input: s = "goalspecial", wordDict = ["go","goal","goals","special"]
Output: false
 */

package leetcode.practice;

import java.util.Arrays;
import java.util.List;

public class Word_Break {

	
	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean [][] tempArr= new boolean[s.length()][s.length()];
		for(int i=0;i<s.length();i++) {
			for(int j=i;j<s.length();j++) {
				if(wordDict.contains( s.substring(i,j+1))) tempArr[i][j]=true;
				else tempArr[i][j]=false;
			}
		}
		return false;
	}
public static boolean wordBreakRec(String s, List<String> wordDict) {
        
		if(s.length()==0) return false;
		if(wordDict.contains(s)) return true;
		for(int i =1;i<=s.length();i++) {
			String tempStr = s.substring(0,i);
			if(wordDict.contains(tempStr) && wordBreak(s.substring(i), wordDict)) {
				return true;
			}
		}
		
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String st = "goalspecial";
		List<String> wordDict =Arrays.asList("go","goal","goals","special");
		System.out.println(wordBreak(st,wordDict ));
	}

}

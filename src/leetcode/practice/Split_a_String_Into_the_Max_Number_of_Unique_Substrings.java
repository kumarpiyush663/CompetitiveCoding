package leetcode.practice;

import java.util.HashSet;

public class Split_a_String_Into_the_Max_Number_of_Unique_Substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxUniqueSplit("addbsd"));

	}

	public static int maxUniqueSplit(String s) {
		
		HashSet<String> tempSet = new HashSet<String>();
		
		String tempStr="";
		for(int i =0;i<s.length();i++) {
			if(i>0 &&s.charAt(i)==s.charAt(i-1) ) continue;
			
			tempStr+=s.charAt(i);
			if(!tempSet.contains(tempStr)) {
				tempSet.add(tempStr);
				tempStr="";
			}
			
			
		}
		return tempSet.size();

	}

}

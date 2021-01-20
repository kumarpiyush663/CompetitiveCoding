package leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Repeated_DNA_Sequences {

	public List<String> findRepeatedDnaSequences(String s) {
        
		List<String> result = new ArrayList<String>();
		if(s.length()<10) return result;
		Map<String, Integer> dnaMap = new LinkedHashMap<String,Integer>();
		
		String string = s.substring(0,10);
		dnaMap.put(string, 1);
		for(int i = 10;i<s.length();i++) {
			string = string.substring(1)+s.charAt(i);
			if(dnaMap.containsKey(string)) dnaMap.put(string, dnaMap.get(string)+1);
			else dnaMap.put(string, 1);
		}
		
		for(Map.Entry<String, Integer> entry : dnaMap.entrySet()) {
			if(entry.getValue()>1) result.add(entry.getKey());
		}
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "AAAAAAAAAAAAA";
		System.out.println(new Repeated_DNA_Sequences().findRepeatedDnaSequences(s));
	}

}

/*
 Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 
 */

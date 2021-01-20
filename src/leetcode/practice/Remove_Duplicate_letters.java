package leetcode.practice;

import java.util.*;

public class Remove_Duplicate_letters {

    public String removeDuplicateLetters(String s) {
    	boolean visited[] = new boolean[26];
    	int lastIndex[] =new int[26];
//    	for(int i =0 ;i<26;i++) visited[i] = false;
    	for(int i =0 ;i<s.length();i++) lastIndex[s.charAt(i)-'a']= i;
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i=0;i<s.length();i++) {
    		int c = s.charAt(i)-'a';
    		if(visited[c]) continue;
    		
    		while(!stack.isEmpty() && stack.peek()>c && i<lastIndex[stack.peek()]) {
    			visited[stack.pop()] = false;
    		}
    		stack.push(c);
    		visited[c] = true;
    		
    	}
    	String string = "";
    	while(!stack.isEmpty()) {
    		
//    		System.out.println((char)(stack.pop()+'a'));
    		string = (char)(stack.pop()+'a')+string;
    	}
    	
    	return string;
    }
    
    

    public static void main(String[] args) {
        String s = "cbacdcbc";
       System.out.println(new Remove_Duplicate_letters().removeDuplicateLetters(s));
       
       
    }
}

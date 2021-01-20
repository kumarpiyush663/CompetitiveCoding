package leetcode.practice;

import java.util.HashSet;
import java.util.Set;

public class Buddy_String {
	
	 public boolean buddyStrings(String A, String B) {
	        if(A.length()!=B.length() || A.length()<=1 || B.length()<=1) return false;        
	        Set<Character> setA = new HashSet<>();
	        Set<Character> setB = new HashSet<>();
	        int a =-1;
	        int b =-1;
	        int diffCount = 0;
	        for(int i=0;i<A.length();i++){
	            setA.add(A.charAt(i));
	            setB.add(B.charAt(i));
	            if(A.charAt(i)==B.charAt(i)) continue;
	            else{
	                if(a==-1) a=i;
	                else b = i;
	                diffCount++;
	            }
	            
	        }        
	        if(A.length()==2 && diffCount==0){
	            if(A.charAt(0)==A.charAt(1)) return true;
	            return false;
	        } 
	        if(A.length()>2 && diffCount==0){
	            if(setA.size()!=A.length()) return true;
	            return false;
	        }
	        if(diffCount==2 && A.charAt(a)==B.charAt(b) && A.charAt(b)==B.charAt(a)) return true;
	        return false;}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String A = "abcd";
		String B = "abcd";
		System.out.println(new Buddy_String().buddyStrings(A, B));
	}

}

package leetcode.practice;

public class Consecutive_Characters {

	
	public int maxPower(String s) {
        int n = s.length();
        if(n==1) return n;
        
        int i =0;
        int res = 1;
        while(i<n){
            int j = i+1;
            while(j<n && s.charAt(j-1)==s.charAt(j)) j++;
            res = Math.max(res,j-i);
            i = j;
            
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcbb"; //ans :-  2
		
		System.out.println(new Consecutive_Characters().maxPower(s));

	}

}

package leetcode.practice;

public class Stone_Game_IV {
	
	 public boolean winnerSquareGame(int n) {
	        if(n==1) return true;
	        if(n==2) return false;
	        boolean []dp = new boolean[n+1];
	        dp[0] = false;
	        dp[1] = true;
	        dp[2] = false;
	        for(int i=3;i<=n;i++){
	            int y = 1;
	            int x = 1;
	            while(x<=i){
	                if(x == i){
	                    dp[i] = true;
	                    break;
	                }
	                if(!dp[i-x]){
	                    dp[i] = true;
	                    break;
	                }
	                y=y+1;              
	                x = y*y;
	            }
	            
	        }
	        return dp[n];
	    }

	public static void main(String[] args) {
		System.out.println(new Stone_Game_IV().winnerSquareGame(17));  // ans false

	}

}

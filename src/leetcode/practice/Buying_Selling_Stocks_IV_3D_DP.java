package leetcode.practice;

public class Buying_Selling_Stocks_IV_3D_DP {

    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length <= 1) return 0;
        int n = prices.length; 
        if(k>=n/2) {

            if(k == 0 || prices.length <= 1) return 0;
            
            
            int i=1;
            int result = 0;
            for(i=0;i<n;i++){
            	
                while(i<n-1 && prices[i+1]<=prices[i]) i++;
                if(i>=n-1) break;
                int x=i;
                i++;
                
                while(i<n && prices[i]>=prices[i-1]) i++;
                int y = i-1;
               
                result= result+prices[y]-prices[x];
                i--;
                
            }

            return result;
        
        }
        else {
        	Integer[][][] dp=new Integer[n+1][k+1][2];
        	
        	return helper(prices, 0, 1, 0, k, dp);
        }
        
    }
    public int helper(int []prices, int i, int buy, int tx,int k, Integer dp[][][]) {
    	if(i>=prices.length || tx>=k) return 0;
    	
    	if(dp[i][tx][buy]!=null) return dp[i][tx][buy];
    	if(buy==1) 
    		return dp[i][tx][buy] = Math.max(-prices[i]+ helper(prices, i+1, 1-buy, tx, k, dp),helper(prices, i+1, buy, tx, k, dp));
    	else 
    		return dp[i][tx][buy] = Math.max(prices[i]+ helper(prices, i+1, 1-buy, tx+1, k, dp),helper(prices, i+1, buy, tx, k, dp));
    	
    	
    }
   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {2,5,7,1,4,3,1,3}; // if k=2 ans 8 , if k= 3 ans 10
		System.out.println(new Buying_Selling_Stocks_IV_3D_DP().maxProfit(3,a));
	}

}

package leetcode.practice;

import java.util.ArrayList;

public class Buying_Selling_Stocks_Atmost_K_Times {

	class Stockrange{
        int low;
        int high;
    }
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length <= 1) return 0;
        int n = prices.length; 
        if(k>=n/2) {

            if(k == 0 || prices.length <= 1) return 0;
            
            ArrayList<Stockrange> strangeList = new ArrayList<>();
            int i=1;
            int result = 0;
            for(i=0;i<n;i++){
            	
                while(i<n-1 && prices[i+1]<=prices[i]) i++;
                if(i>=n-1) break;
                int x=i;
                i++;
                
                while(i<n && prices[i]>=prices[i-1]) i++;
                int y = i-1;
                
                Stockrange strange = new Stockrange();
                strange.low = prices[x];
                strange.high = prices[y];
                
                strangeList.add(strange);
                result= result+prices[y]-prices[x];
                i--;
                
            }

            return result;
        
        }
        else {   	
        	
        	
			int[][] dp = new int[2][n];

			for (int i = 0; i < 2; i++)
				dp[i][0] = 0;
			for (int i = 0; i < n; i++)
				dp[0][i] = 0;
			
			for (int i = 1; i <= k; i++) {
				int max_val = Integer.MIN_VALUE;
				for (int j = 1; j < n; j++) {
					int flag = 1 - (i & 1);
					max_val = Math.max(max_val, dp[flag][j - 1] - prices[j - 1]);
					dp[(i & 1)][j] = Math.max(dp[(i & 1)][j - 1], prices[j] + max_val);
				}
			}

			
        	for(int j=0;j<n;j++) System.out.print(prices[j]+" ");
    		System.out.println("\n");
        	for(int i=0;i<2;i++) {
        		for(int j=0;j<n;j++) System.out.print(dp[i][j]+" ");
        		System.out.println();
        	}
			return dp[(k & 1)][n - 1];
        }
        
    }
   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {2,5,7,1,4,3,1,3}; // if k=2 ans 8 , if k= 3 ans 10
		System.out.println(new Buying_Selling_Stocks_Atmost_K_Times().maxProfit(3,a));
	}

}

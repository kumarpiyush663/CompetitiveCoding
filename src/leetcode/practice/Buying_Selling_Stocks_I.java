package leetcode.practice;

public class Buying_Selling_Stocks_I {
	
	public int maxProfit(int[] prices) {
	       
        if(prices.length<=1) return 0;
        int mintill = prices[0];
        int result =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>mintill) result = Math.max(prices[i]-mintill,result);
            mintill = Math.min(mintill,prices[i]);
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {100, 180, 260, 310, 40, 535, 695}; // ans 655
		System.out.println(new Buying_Selling_Stocks_I().maxProfit(a));
	}

}

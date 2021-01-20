package leetcode.practice;

import java.util.ArrayList;

class Stocks{
	int buy,sell;
}
public class Buying_Selling_Stocks_II {

	void maxProfit(int a[]) {
		
		int n = a.length;
		int i=0;
		ArrayList<Stocks> st = new ArrayList<Stocks>();
		
		ArrayList<Integer> diff = new ArrayList<>();
		while(i<n-1) {
			
			while((i<n-1) && a[i+1]<=a[i]) i++;
			
			if(i==n-1) break;
			
			Stocks stocks = new Stocks();
			stocks.buy = i;
			i++;
			
			while((i<n) && a[i]>=a[i-1]) i++;
			
			stocks.sell = i-1;
			
			st.add(stocks);
			
			diff.add(a[stocks.sell]-a[stocks.buy]);
		}
		
		int result = 0;
		if(st.size()==0) System.out.println("There is no day when buying the stock will make profit");
		
		else {
			 for (int j = 0; j < st.size(); j++) {
	                System.out.println("Buy on day: " + st.get(j).buy 
	                                   + "        "
	                                   + "Sell on day : " + st.get(j).sell); 
	                result+= a[st.get(j).sell]-a[st.get(j).buy];
	  
			 }
	       
			 System.out.println("Profit: "+result);
		}
		
		
		 return; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {100, 180, 260, 310, 40, 535, 695}; // ans 865
		new Buying_Selling_Stocks_II().maxProfit(a);
	}

}

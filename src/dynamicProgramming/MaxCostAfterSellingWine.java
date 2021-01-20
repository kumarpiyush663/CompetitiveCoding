/*
    https://www.hackerearth.com/practice/notes/dynamic-programming-i-1/
    
    
    "Imagine you have a collection of N wines placed next to each other on a shelf. For simplicity, let's number the wines from left to right as they are standing on the shelf with integers from 1 to N, respectively. The price of the ith wine is pi. (prices of different wines can be different).

Because the wines get better every year, supposing today is the year 1, on year y the price of the ith wine will be y*pi, i.e. y-times the value that current year.

You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year. One more constraint - on each year you are allowed to sell only either the leftmost or the rightmost wine on the shelf and you are not allowed to reorder the wines on the shelf (i.e. they must stay in the same order as they are in the beginning).

You want to find out, what is the maximum profit you can get, if you sell the wines in optimal order?"

So, for example, if the prices of the wines are (in the order as they are placed on the shelf, from left to right): p1=1, p2=4, p3=2, p4=3. The optimal solution would be to sell the wines in the order p1, p4, p3, p2 for a total profit 1 * 1 + 3 * 2 + 2 * 3 + 4 * 4 = 29.
  
   n = 5
	4
	1 4 2 3
	output = 29
	5
	2 3 5 1 4
	output = 50
    
 */

package dynamicProgramming;

import java.util.Scanner;

public class MaxCostAfterSellingWine {
	
	static int N;
	static int dp[][];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int test = scanner.nextInt();
		while (test>0) {
			int n = scanner.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i]=scanner.nextInt();
			
			
			
			
			//using DP
			
			N=n;
			dp = new int[N+1][N+1];
			setdp(dp,N);
			MaxCostAfterSellingWineDP(a,0,n-1,1);

			int xyz = -1;
			for(int i=0;i<=N;i++) for(int j= 0;j<=N;j++) xyz = max(xyz, dp[i][j]);
			
		
			System.out.println("xyz = "+xyz);
			
			
			int x = MaxCostAfterSellingWineRecurssive(a,0,n-1,1);
			System.out.println("x = "+x);
			test--;
		}
	}

	public static int MaxCostAfterSellingWineRecurssive(int a[],int start,int end,int year){
		if(start>end) return 0;
		
		return max(MaxCostAfterSellingWineRecurssive(a, start+1, end, year+1)+a[start]*year,
				MaxCostAfterSellingWineRecurssive(a, start, end-1, year+1)+a[end]*year);
		
		
	}
	public static int MaxCostAfterSellingWineDP(int a[],int start,int end,int year){
		if(start>end) return 0;
		
		if(dp[start][end]!=-1) return dp[start][end];
		
		return dp[start][end] = max(MaxCostAfterSellingWineDP(a, start+1, end, year+1)+a[start]*year,
				MaxCostAfterSellingWineDP(a, start, end-1, year+1)+a[end]*year);
		
		
	}
	
	public static int max(int x,int y) {
		return x>y?x:y;
	}
		
	public static void setdp(int d[][],int N) {
		for(int i=0;i<=N;i++) {
			for(int j= 0;j<=N;j++) dp[i][j]= -1;
		}
	}
}

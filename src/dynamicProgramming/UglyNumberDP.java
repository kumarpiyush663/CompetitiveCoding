package dynamicProgramming;

import java.util.Scanner;

public class UglyNumberDP {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();
		while(test>0) {
			
			int n = scanner.nextInt();
			System.out.println(uglyNumberDP(n));
			
			test--;
		}
	}
	
	public static int uglyNumberDP(int n) {
		
		int dp[] = new int[n];
		dp[0]=1;
		
		int x=0,y=0,z=0;
		int var_2 =2 ,var_3=3,var_5=5;
		for(int i=1;i<n;i++) {
			dp[i]=min(var_2,min( var_3, var_5));
			
			if(dp[i]==var_2) {
				x+=1;
				var_2=2*dp[x];
			}
			if(dp[i]==var_3) {
				y+=1;
				var_3=3*dp[y];
			}
			if(dp[i]==var_5) {
				z+=1;
				var_5=5*dp[z];
			}
//			System.out.print(dp[i]+" ");
		}
//		System.out.println();
		return dp[n-1];
	}

	public static int min(int x,int y) {
		
		if(x<y) return x;
		
		return y;
	}
}

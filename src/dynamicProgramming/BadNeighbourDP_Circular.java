package dynamicProgramming;

import java.util.Scanner;

public class BadNeighbourDP_Circular {

	public static void main(String[] args) {


//		int x=5,y=2;
//		System.out.println((x>>2)>>>2);

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();

		while(test>0) {
			
			int n= in.nextInt();

			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=in.nextInt();
			}	
			int sum=0;
			int[] dp = new int[arr.length+2];
			for(int i =0 ;i<=arr.length+1;i++) dp[i]=-1;
			dp[0]=0;
			if(n==0) sum=0;
			else if(n==1) sum=arr[0]; 
			else sum =FindMaxSum(arr,n);
			System.out.println(sum);
			test--;		
		}
	
	
		
	}
	
	private static int FindMaxSum(int arr[], int n) 
	{ 
		if(n==2) return max(arr[0],arr[1]);
		
		int dp[] = new int[n],flag[]= new int[n];
		
		dp[0]=arr[0];
		dp[1]=arr[1];
		flag[0]=1;
		flag[1]=0;
		
		for(int i=2;i<n;i++){
			dp[i]=0;
			flag[i]=0;
		}
		
		for(int i=2;i<n;i++){
			for(int j=0;j<i-1;j++){
				if(dp[i]<dp[j]+arr[i]){
					dp[i]=dp[j]+arr[i];
					flag[i]=flag[j];
				}
			}
		}
		
		if(flag[n-1]==0) return dp[n-1];
		else{
			int temp =  min(arr[0],arr[n-1]);
			dp[n-1] = max(dp[n-2],dp[n-1]-temp);
		}
		
		return dp[n-1];
		
	} 

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if(i>j) return i;
		else if (j>i) return j;
		else return i;
	}

	private static int min(int i, int j) {
		// TODO Auto-generated method stub
		if(i>j) return j;
		else if (j>i) return i;
		else return i;
	}
}

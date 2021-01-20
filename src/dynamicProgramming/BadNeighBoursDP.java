package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// https://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009

public class BadNeighBoursDP {
	
	public static int finalval=0;

	public static void main(String[] args)  {
		try {


			@SuppressWarnings("resource")
//			Scanner in = new Scanner(System.in);
//			int test = in.nextInt();
//			
			BufferedReader reader =
	                new BufferedReader(new InputStreamReader(System.in));
			
			int test=Integer.parseInt(reader.readLine().trim());
			while(test>0) {
				int n=Integer.parseInt(reader.readLine().trim());
//				String temp[] = reader.readLine().split(" ");
				
				int arr[] = new int[n];
				for(int i=0;i<n;i++) {
//					arr[i]=Integer.parseInt(temp[i].trim());
					arr[i]=Integer.parseInt(reader.readLine().trim());
				}	
				int sum=0;
				int[] dp = new int[arr.length+2];
				for(int i =0 ;i<=arr.length+1;i++) dp[i]=-1;
				dp[0]=0;
				finalval=0;
				if(n==0) sum=0;
				else if(n==1) sum=arr[0];
//				else if(arr.length==2) res[arr.length]=max(arr[0], arr[1]); 
				else sum =calBadNeighbour(arr,0,n,sum,dp);
//				sum = calBadNeighbour(arr,0,n,sum,dp);
				System.out.println(sum);
				test--;		
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int calBadNeighbour(int a[],int startIndex , int size,int sum,int dp[]) {
		dp[size]= 0;
		dp[size+1]=0;
		boolean flag = false;
		for(int i=size-1;i>=0;i--) {
//			if(i==size-2) {
//				if(a[i]+dp[i+2]< dp[i+1]) flag = true;
//			}
//			if(i==0 && flag==true && a[i]+dp[i+2]> dp[i+1]) {
//				if(a[i]>a[size-1]) dp[i] = a[i]+dp[i+2]-a[size-1];
//				else dp[i]=max(a[i]+dp[i+2], dp[i+1]);
//				System.out.println("dp["+i+"] = "+dp[i]);
//			}
//			else {
//				dp[i]=max(a[i]+dp[i+2], dp[i+1]);
//				System.out.println("dp["+i+"] = "+dp[i]);
//			}

			dp[i]=max(a[i]+dp[i+2], dp[i+1]);
			System.out.println("dp["+i+"] = "+dp[i]);
		
		}
		return dp[0];
	}
	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if(i>j) return i;
		else if (j>i) return j;
		else return i;
	}
	private static int max(int k, int i, int j) {
		if(i>j && i>k) return i;
		else if(j>k && j>i) return j;
		else return k;
	}

}
/*

2
6
10
3
2
5
7
8  
  
 */


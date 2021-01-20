
// https://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009

package dynamicProgramming;

import java.util.Scanner;

// https://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009

public class BadNeighbours {
	
	public static int finalval=0;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test>0) {
			int n=in.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=in.nextInt();
			}	
			int sum=0;
			finalval=0;
			if(arr.length==0) finalval=0;
			else if(arr.length==1) finalval=arr[0];
			else if(arr.length==2) finalval=max(arr[0], arr[1]); 
			else sum =calBadNeighbour(arr,0,n,sum);
			System.out.println(finalval);
			test--;		
		}	
	}
	
	public static int calBadNeighbour(int a[],int startIndex , int size,int sum) {
		
		if(startIndex>=size) return 0;
		if(startIndex==size-1 ) return sum+a[startIndex];
		if(startIndex==size-2) return max(sum, sum+a[startIndex+1]);
//		for(int i=startIndex;i<size;i++) {}

		int i = startIndex;
		System.out.println("sum in i = "+i+", sum = "+sum);
		int x,y;
		if(i==0) x= calBadNeighbour(a,i+2,size-1,sum+a[i]);
		else x= calBadNeighbour(a,i+2,size,sum+a[i]);
		 y=calBadNeighbour(a,i+1,size,sum);
		 finalval=max(finalval, x,y);
		 System.out.println("x & y in i = "+i+", x = "+x+", y = "+y);
		 System.out.println("finalval in i = "+i+", finalval = "+finalval);
	
		
		return finalval;
	}
	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if(i>j) return i;
		else if (j>i) return j;
		else return 1;
		
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

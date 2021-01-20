package dynamicProgramming;

import java.util.Scanner;

public class LongestZigZag {

	@SuppressWarnings("resource")
	public static void main(String[] args) {	
		
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test>0) {
			int n=in.nextInt();
			int arr[] = new int[n];
			int arrlargedp[] = new int[n];
			int arrsmalldp[] = new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=in.nextInt();
				arrlargedp[i]=1;
				arrsmalldp[i]=1;
			}			
			
			int largeval =0;
			for(int i=1;i<n;i++) {
				for(int j=0;j<i;j++) {
					if(arr[i]>arr[j]&& arrlargedp[i]<arrsmalldp[j]+1 ) {
						arrlargedp[i] = max(arrlargedp[i],arrsmalldp[j]+1);
					}
					else if(arr[i]<arr[j] && arrsmalldp[i]<arrlargedp[j]+1 ) {
						arrsmalldp[i] = max(arrsmalldp[i],arrlargedp[j]+1);
					}
				}
				
			}
			
			
			for(int i=0;i<n;i++) {
				
				System.out.println("arr["+i+"] :: "+arr[i]+" arrsmalldp["+i+"] :: "+arrsmalldp[i]+"  ,arrlargedp["+i+"] :: "+arrlargedp[i]);
				largeval = max(largeval, arrsmalldp[i],arrlargedp[i]);
				
			}
		
			System.out.println("largeval :: "+largeval);
			test--;		
		}
		
	}

	private static int max(int k, int i, int j) {
		
		if(i>j && i>k) return i;
		else if(j>k && j>i) return j;
		else return k;
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if(i>j) return i;
		else if (j>i) return j;
		else return 1;
		
	}

}

package dynamicProgramming;

import java.util.Scanner;

public class BadNeighbourIterative {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while (test > 0) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			int sum = 0;

			if(n==1) sum=arr[0];
			else if(n==2) sum = max(arr[0],arr[1]);
			else sum = calBadNeighbourIterative(arr, n);
			System.out.println(sum);
			test--;
		}

	}

	public static int calBadNeighbourIterative(int arr[], int n) {

		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;
		boolean flag = false;

		for (i = 1; i < n; i++) {

			excl_new = (incl > excl) ? incl : excl;

			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		

		}

		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl);
	}
	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if(i>=j) return i;
		else if (j>i) return j;
		else return 1;
		
	}
}

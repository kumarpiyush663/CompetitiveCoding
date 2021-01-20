/**
 * 
 */
package GeeksForGeeks;

import java.util.Scanner;

/**
 * @author Piyush12.Kumar
 *
 */
public class MicroSoft_EaseOfArray {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		int t;
		t = scanner.nextInt();
		for (int test = 0; test < t; test++) {
			int n = scanner.nextInt();
			int arr[] = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}
			for (int i = 0; i < n - 1; i++) {
				if (arr[i] == arr[i + 1]) {
					arr[i] = 2 * arr[i];
					arr[i + 1] = 0;

				}
			}
			int a[] = new int[n];
			for (int i = 0; i < n; i++) a[i]=0;
			int j=0;
			for (int i = 0; i < n; i++) {
				if(arr[i]!=0) a[j++]=arr[i];
			}

			for (int i = 0; i < n; i++) System.out.print(a[i]+" ");
			System.out.println();
		}

	}

}

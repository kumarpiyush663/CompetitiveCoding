package GeeksForGeeks;

import java.util.Scanner;

public class InversionCount {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t;
		t = scanner.nextInt();
		while (t > 0) {
			int n;
			n = scanner.nextInt();
			long a[] = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = scanner.nextInt();
			System.out.println(inversionCount(a, n));
			t--;
		}
	}

	public static long inversionCount(long a[], int arr_size) {
		long temp[] = new long[arr_size];

		return mergeSort(a, temp, 0, arr_size - 1);
	}

	public static long mergeSort(long a[], long temp[], int l, int r) {

		int mid;
		long inv_count = 0;
		if (l < r) {
			mid = (l + r) / 2;
			inv_count += mergeSort(a, temp, l, mid);
			inv_count += mergeSort(a, temp, mid + 1, r);
			inv_count += merge(a, temp, l, mid+1, r);
		}
		return inv_count;
	}

	public static long merge(long[] arr, long[] temp, int left, int mid, int right) {
		int i, j, k;
		int inv_count = 0;

		i = left;
		j = mid;
		k = left;

		while (i <= mid-1 && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inv_count = inv_count + (mid - i);
			}
			

		}
		 while (i <= mid - 1) 
		        temp[k++] = arr[i++]; 
		  
		    while (j <= right) 
		        temp[k++] = arr[j++]; 
		  
		    for (i = left; i <= right; i++) 
		        arr[i] = temp[i]; 
		  
		    return inv_count; 


	}
}

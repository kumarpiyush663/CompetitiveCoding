package leetcode.weekly;

public class CanFormArray_5554 {
	
	public boolean canFormArray(int[] arr, int[][] pieces) {
        
		int k = 0;
		int l = arr.length;
		
		for(int i=0;i<pieces.length;i++) {
			int left[]= new int[pieces[i].length];
			int right[]= new int[pieces[i].length];
			
			int p = k;
			int q = arr.length-pieces[i].length;
			for(int j=0;j<pieces[i].length;j++) {
				left[j]=arr[p];
				right[j]= arr[q];
				p++;
				q++;
			}
			System.out.println(" k = "+k+" l = "+l+" p = "+p+" q = "+q+" ");
			for(int j=0;j<pieces[i].length;j++) System.out.print(left[j]+" ");
			System.out.println();
			for(int j=0;j<pieces[i].length;j++) System.out.print(right[j]+" ");
			System.out.println();
			boolean leftVal = true;
			for(int j=0;j<pieces[i].length;j++) {
				if(left[j]!=pieces[i][j]) {
					leftVal = false;
					break;
				}
			}
			boolean rightVal = true;
			if(!leftVal) {
				for(int j=0;j<pieces[i].length;j++) {
					if(right[j]!=pieces[i][j]) {
						rightVal = false;
						return false;
						
					}
				}
			}
			
//			if(!leftVal && !rightVal) return false;
			
			if(leftVal) k = p;
			else if(rightVal) l = arr.length-pieces[i].length-q-1;
			
		}
		
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int arr[] = {85};
//		int pieces[][] = {{85}};
//		ans = true
		
//		int arr[] = {15,88};
//		int pieces[][] = {{88},{15}};
//		ans = true
		
//		int arr[] = {49,18,16};
//		int pieces[][] = {{16,18,49}};
//		ans = false
		
		int arr[] = {91,4,64,78};
		int pieces[][] = {{78},{4,64},{91}};
//		ans = true
		
		System.out.println(new CanFormArray_5554().canFormArray(arr, pieces));

	}

}

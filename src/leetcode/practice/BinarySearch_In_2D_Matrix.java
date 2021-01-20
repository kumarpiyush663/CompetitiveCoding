package leetcode.practice;

public class BinarySearch_In_2D_Matrix {

	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;
        if(matrix[0][0]>target || matrix[matrix.length-1][matrix[0].length-1]<target) return false;
        int low =0;
        int high = matrix.length-1;
        int rowNum = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target) {
                rowNum = mid;
                break;
            }
            if(matrix[mid][0]>target) high = mid-1;
            else low = mid+1;
        }
       
        
        if(rowNum==-1) return false;
        if(matrix[rowNum][0]==target) return true;
        if(matrix[rowNum][matrix[rowNum].length-1]<target) return false;
//        rowNum = low-1;
//        System.out.println("rowNum = "+rowNum);
        low =0;
        high = matrix[rowNum].length;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[rowNum][mid]==target) {
                return true;
            }
            if(matrix[rowNum][mid]>target) high = mid-1;
            else low = mid+1;
        }
        return false;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		for(int i=0;i<61;i++)
			System.out.println("i = "+i+ " "+new BinarySearch_In_2D_Matrix().searchMatrix(a, i));

	}

}

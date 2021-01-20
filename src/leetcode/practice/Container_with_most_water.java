package leetcode.practice;
/*

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.


Example 2:

Input: height = [1,1]
Output: 1


Example 3:

Input: height = [4,3,2,1,4]
Output: 16


Example 4:

Input: height = [1,2,1]
Output: 2
*/
public class Container_with_most_water {

	// TC :- O(n)
	public int maxArea(int[] height) {
        int res =0 ;
         
         int i =0;
         int j = height.length-1;
         while(i<j){
             res = Math.max(Math.min(height[j],height[i])*(j-i) , res);
             if(height[i]<height[j]) i++;
             else j--;
         }
        
          
        return res;
    }
	
	
	// TC :- O(n2)
	public int maxArea1(int[] height) {
        int res =0 ;
        for(int i=0;i<height.length;i++) for(int j=0;j<i;j++) 
            res = Math.max(Math.min(height[j],height[i])*(i-j) , res);
          
        return res;
    }
    
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
 */

package leetcode.practice;

public class Subarray_Product_Less_Than_K {

	
	 public static int numSubarrayProductLessThanK(int[] nums, int k) {
	        int count =0;
	        int prod =1;
	        int i=0,j=0;
	        int temp[] = new int[nums.length];
	        for(i=0;i<nums.length;i++){
	            prod= prod*nums[i];
	            if(prod>=k) while(prod>=k && j<i) {
	            	prod= prod/nums[j];
	            	j=j+1;
	            }
	            temp[i]=j;
	        }
	        
	        for(i=0;i<nums.length;i++){
	            count+=i-temp[i];
	            if(nums[i]<k) count++;
	        }
	        
	        for(i=0;i<nums.length;i++){
	           System.out.print(temp[i]+" ");
	        }
	        
	        System.out.println();
	        return count;
	    }
	public static void main(String[] args) {
		int[] nums = {10, 5, 2, 6};
		int k = 100;
		
		
		System.out.println(numSubarrayProductLessThanK(nums, k));

	}

}

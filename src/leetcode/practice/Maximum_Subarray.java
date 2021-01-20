package leetcode.practice;

public class Maximum_Subarray {

	public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        
        int maxSum = nums[0];
        
        int recentSum = nums[0];
        for(int i=1;i<nums.length;i++){
            
            recentSum = recentSum+nums[i];
            if(recentSum<nums[i]) recentSum = nums[i];
            if(recentSum>maxSum) maxSum = recentSum;
            
            
        }
        return maxSum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {-2,1,-3,4,-1,2,1,-5,4}; // ans 6
		System.out.println(new Maximum_Subarray().maxSubArray(a));
	}
}

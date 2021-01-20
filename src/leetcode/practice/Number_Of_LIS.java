package leetcode.practice;

import java.util.Arrays;

public class Number_Of_LIS {
	
	public int findNumberOfLIS(int[] nums) {
        if(nums.length<2) return nums.length;
        
        int maxRes =-1;
        int dp[] = new int[nums.length];
        int mx[] = new int[nums.length];
        Arrays.fill(mx,1);
       
        for(int j=0;j<nums.length;j++){
            for(int i=0;i<j;i++){          
                
                if(nums[i]<nums[j]){
                    if(dp[i]+1==dp[j]){
                        mx[j]+=mx[i];
                    }
                    else if(dp[i]>=dp[j]){
                         dp[j]=dp[i]+1;
                        mx[j]=mx[i];
                        maxRes = Math.max(maxRes,dp[j]);
                    }
                    
                }
                           
            }
   
        }

        int ans = 0;        
        if(maxRes == -1) return nums.length;
        for (int i = 0; i < dp.length; ++i) {
            if (dp[i] == maxRes) {
                ans += mx[i];
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		[1,3,5,4,7]  ans : 2
//		[1,2]		 ans : 1
//		[2,2,2,2,2]	 ans : 5
		
		int []nums = {1,3,5,4,7};
		System.out.println(new Number_Of_LIS().findNumberOfLIS(nums));
	}

}

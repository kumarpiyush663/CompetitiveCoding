package leetcode.practice;

public class House_robber_II {
	
	public int max(int a, int b) {
		return a>=b?a:b;
	}

	public int rob(int[] nums) {
		
		if(nums.length==0) return 0;
		if(nums.length ==1) return nums[0];
//		boolean[] isIncluded = new boolean[nums.length];
		int []dp =new int[nums.length];
//		isIncluded[0] = true;
		dp[0] = nums[0];
		
		dp[1] = dp[0];
		for(int i=2;i<nums.length-1;i++) {
			dp[i] = max(nums[i]+dp[i-2], dp[i-1]);
		}
		int flag1 = dp[nums.length-2];
		dp[0]=0;
		dp[1] = nums[1];
		for(int i=2;i<nums.length;i++) {
			dp[i] = max(nums[i]+dp[i-2], dp[i-1]);
		}
		
		for(int i=0;i<nums.length;i++) System.out.print(nums[i]+ " ");
		System.out.println();
		for(int i=0;i<nums.length;i++) System.out.print(dp[i]+ " ");
		System.out.println();
        return max(dp[nums.length-1],flag1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int []a = {2,3,2}; // ans 3
//		int []a = {1,2,3,1};
//		int a[] = {1,1,1,2};
		
//		int []a = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3}; // ans 41
		int []a = {2,2,4,3,2,5}; // ans 10
		System.out.println(new House_robber_II().rob(a));
	}

}

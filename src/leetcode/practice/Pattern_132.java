package leetcode.practice;

import java.util.Stack;

public class Pattern_132 {

	
	// TC- O(n)
			 public boolean find132pattern(int[] nums) {
			        if(nums.length<3) return false;
			       int n =  nums.length;
			       int minTill[] = new int[n];
			       minTill[0] = nums[0];
			       for(int i=1;i<n;i++) minTill[i] = Math.min(minTill[i-1],nums[i]);
			       
			       Stack<Integer> stack = new Stack<>();
			       for(int i=n-1;i>0;i--){
			    	   int minVal = minTill[i-1];			    	   
			    	   while(!stack.empty() && stack.peek() <= minVal) stack.pop();
			    	   if(!stack.empty() && stack.peek()< nums[i]) return true;
			    	   
			    	   stack.push(nums[i]);
			       }      
			         return false;
			    }
	
	
	// TC- O(n2)
		 public boolean find132pattern1(int[] nums) {
		        if(nums.length<3) return false;
		       int n =  nums.length;
		       int minTill[] = new int[n];
		       minTill[0] = nums[0];
		       for(int i=1;i<n;i++) minTill[i] = Math.min(minTill[i-1],nums[i]);
		       for(int i=1;i<n-1;i++){
		           
		    	   i++;
		           while(i<n-1 && nums[i]>=nums[i-1]) i++;
		           int y = nums[i-1];
		           
//		           System.out.println(x+" "+y);
		           for(int j =i;j<n;j++) if(y>minTill[i-2] && y>nums[j] && nums[j]>minTill[i-2]) return true;
		           i--;
		       }      
		         return false;
		    }
	
	// TC- O(n2)
	 public boolean find132pattern2(int[] nums) {
	        if(nums.length<3) return false;
	       int n =  nums.length;
	       for(int i=0;i<n-1;i++){
	           
	           while(i<n-1 && nums[i+1]<=nums[i]) i++;
	           int x = nums[i];
	           if(i>=n) break;
	           i++;
	           while(i<n-1 && nums[i]>=nums[i-1]) i++;
	           int y = nums[i-1];
	           
//	           System.out.println(x+" "+y);
	           for(int j =i;j<n;j++) if(y>x && y>nums[j] && nums[j]>x) return true;
	           i--;
	       }      
	         return false;
	    }
	 
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int a[]= {100, 180, 260, 310, 40, 535, 695}; // ans false
		int a[]= {-1,3,2,0};  // ans true
		System.out.println(new Pattern_132().find132pattern(a));
	}

}

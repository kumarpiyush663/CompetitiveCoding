package leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {
	
public List<String> summaryRanges(int[] nums) {
        
        List<String> result = new ArrayList<>();
        if(nums.length==0) return result;
        
        if(nums.length==1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }
        
        int i=0;
        String temp = "";
        while(i<nums.length-1){
            int count = 1;
            temp = String.valueOf(nums[i]);
            while(nums[i+1]-1==nums[i]){
                i++;
                count++;
                if(i>=nums.length-1) break;
            }
            if(count>1) temp = temp+"->"+nums[i];
            temp = String.valueOf(temp);
            result.add(temp);
            i++;
        }
        if(i==nums.length-1) result.add(String.valueOf(nums[i]));
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {0,1,2,4,5,7};  // Output: ["0->2","4->5","7"]
		List<String> result = new Summary_Ranges().summaryRanges(nums);
		for(String str : result) System.out.print(str+" ");

	}

}

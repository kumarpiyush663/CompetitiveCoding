package leetcode.practice;

public class Maximize_Distance_To_Closest_Person {
	
	

	    public int maxDistToClosest(int[] seats) {
	        int result = Integer.MIN_VALUE;
	        
	        if(seats[seats.length-1]==0){
	            for(int i=seats.length-1;i>=0;i--){
	                if(seats[i]==1) {
	                    result = Math.max(result, seats.length-1-i);
	                    break;
	                }
	            }
	        }
	        if(seats[0]==0){
	            for(int i=0;i<seats.length;i++){
	                if(seats[i]==1) {
	                    result = Math.max(result, i);
	                    break;
	                }
	            }
	        }
	        int x = 0;
	        int i=1;
	        while(i<seats.length){
	                if(seats[i]==1){
	                    if(i-x>1){
	                        int mid = (i+x)/2;
	                        result = Math.max(result, Math.min(mid-x, i-mid));
	                        x = i;
	                    }
	                    else x++;
	                    
	                }
	                i++;
	            }
	        return result;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {1,0,0,0,1,0,1};  // Output: 2
//		int []nums = {1,0,0,0};  // Output: 3
		
		System.out.println(new Maximize_Distance_To_Closest_Person().maxDistToClosest(nums));

	}

}

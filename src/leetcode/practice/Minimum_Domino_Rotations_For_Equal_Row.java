/*

	In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

 

Example 1:


Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 

Constraints:

2 <= A.length == B.length <= 2 * 104
1 <= A[i], B[i] <= 6
*/

package leetcode.practice;

import java.util.*;

public class Minimum_Domino_Rotations_For_Equal_Row {

	
	 public int minDominoRotations(int[] A, int[] B) {
	        Map<Integer, ArrayList<Integer> > mapVal = new HashMap<>();
	        int sameCount=0;
	        boolean temp = true;
	        int checkEq = Integer.MAX_VALUE;
	        for(int i=0;i<A.length;i++){
	           if(A[i]!=B[i]){
	               temp = false;
	            if(mapVal.containsKey(A[i])) {
	                ArrayList<Integer> list = mapVal.get(A[i]);
	                int x = list.get(0);
	                x++;
	                list.set(0,x);
	                mapVal.put(A[i],list);
	            }
	            else{
	                ArrayList<Integer> list = new ArrayList<>();
	                list.add(1);
	                list.add(0);
	                mapVal.put(A[i],list);
	            }
	            
	            // 
	            if(mapVal.containsKey(B[i])) {
	                ArrayList<Integer> list = mapVal.get(B[i]);
	                int x = list.get(1);
	                x++;
	                list.set(1,x);
	                mapVal.put(B[i],list);
	            }
	            else{
	                ArrayList<Integer> list = new ArrayList<>();
	                list.add(0);
	                list.add(1);
	                mapVal.put(B[i],list);
	            }}
	            else{
	                if(checkEq == Integer.MAX_VALUE) checkEq = A[i];
	                else if(checkEq!= A[i]) return -1;
	                sameCount++;
	            }
	        }
	        if(temp) return 0;
	        int result = Integer.MAX_VALUE;
	        for(Map.Entry<Integer, ArrayList<Integer> > entry : mapVal.entrySet()){
	             ArrayList<Integer> list = entry.getValue();
	            // System.out.println(entry.getKey()+"  :: "+list.get(0)+" "+list.get(1));
	            if(list.get(0)+list.get(1)>=(A.length-sameCount)){
	                
	                result = Math.min(result,Math.min(list.get(0),list.get(1)));
	            }
	        }
	        if(result == Integer.MAX_VALUE) return -1;
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

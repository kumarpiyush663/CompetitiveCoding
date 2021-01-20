
/*
 
  
  
  test case failed 
  
  {1,2,3,4,5,6}
{1,3,1,3,1,3}
{2,4,2,4,2,4}

 */


package dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlowerGarden {

	public static void main(String[] args) {
		
		try {
			BufferedReader reader =
			        new BufferedReader(new InputStreamReader(System.in));
			
			int test=Integer.parseInt(reader.readLine().trim());
			while(test>0) {
				String heightstr = reader.readLine().trim();
				String bloomstr = reader.readLine().trim();
				String wiltstr = reader.readLine().trim();
				heightstr = heightstr.substring(1, heightstr.length()-1);
				bloomstr = bloomstr.substring(1, bloomstr.length()-1);
				wiltstr = wiltstr.substring(1, wiltstr.length()-1);
//				System.out.println(heightstr.toString());
//				System.out.println(bloomstr.toString());
//				System.out.println(wiltstr.toString());
				
				String height[]=heightstr.split(",");
				String bloom[]=bloomstr.split(",");
				String wilt[]=wiltstr.split(",");
				
				int heightInt[]=new int[height.length];
				int bloomInt[]=new int[height.length];
				int wiltInt[]=new int[height.length];
				
				for(int i=0;i<height.length;i++) {					
					heightInt[i] = Integer.parseInt(height[i].trim());
					bloomInt[i] = Integer.parseInt(bloom[i].trim());
					wiltInt[i] = Integer.parseInt(wilt[i].trim());
				}
//				int result[] = new int[height.length];
				int [] result = getOrderingDynamicProgramming(heightInt,bloomInt,wiltInt);
				
				for(int i=0;i<height.length;i++) {					
					System.out.print(result[i]+" ");
				}
				System.out.println();
				test--;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

/**
 * implementing a dynamic programming solution as an exercise for 
 * https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/
 * 
 * The runtime complexity is O(N^2).
 * 
 Note, that their Test 4 shows that the end result is consistent with rules
 only for adjacent rows.
 result indexes= 1 3 5 0 2 4  from original order
          height 2 4 6 1 3 5
          bloom  3 3 3 1 1 1
          wilt   4 4 4 2 2 2
            ROW  0 1     4
 For example, ROW 0 compared to ROW 1 follows the rules,
 but ROW 0 compared to ROW 4 does not follow the rules.

 By the same understanding, the solution to Test 4 using this dynamic programming
 implementation is consistent with the rules.
 This equally valid solution from this is
          height 6 5 4 3 2 1
          bloom  3 1 3 1 3 1
          wilt   4 2 4 2 4 2
 
 * @param height has between 1 and 50 elements, inclusive.
 * the items are all unique.
 * each of value is between 1 to 1000, inclusive.
 * @param bloom 
 * each of value is between 1 to 365, inclusive.
 * @param wilt
 * each of value is between 1 to 365, inclusive.
 * wilt[i] will always be greater than bloom[i].
 * 
 * @return 
 */
public static int[] getOrderingDynamicProgramming(int[] height, int[] bloom, int[] wilt) {
    
    /*
    for a dynamic approach, memo needs 2 dimensions to store each "best".
    A reverse index one-dimensional array is used for back tracking after
    the the pair-wise comparisons.
    The runtime is roughly 2 * O((N^2)/2).
    */
    
    int n = height.length;
     
    // stores the "best" of i, j comparison as the value
    int[][] memo = new int[n][];
    
    // the index is used for the "best" of the i,j comparison, and the
    // value is the "best" of the others in the comparison.  This is used
    // for back tracking after the smallest overall index is known.
    int[] memoValues = new int[n];
    Arrays.fill(memoValues, -1);
            
    int smallestIdx = -1;
    
    for (int i = 0; i < n; i++) {
        
        memo[i] = new int[n];
        
        boolean smallestIdxIsI = true;
        
        for (int j = (i + 1); j < n; j++) {
            
            int currentSmallestIdx = j;
            
            boolean disjunct = (bloom[i] > wilt[j]) || (wilt[i] < bloom[j]);
      
            if (height[i] > height[j]) {
                if (disjunct) {
                    // tallest
                    currentSmallestIdx = i;
                }
            }
            
            if (currentSmallestIdx != i) {
                smallestIdxIsI = false;
            }
                            
            memo[i][j] = currentSmallestIdx;                
        }
        
        if ((smallestIdx == -1) && smallestIdxIsI) {
            smallestIdx = i;
        }
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = (i + 1); j < n; j++) {
            int currentSmallestIdx = memo[i][j];
            int v;
            if (memoValues[currentSmallestIdx] > -1) {
                int a = memoValues[currentSmallestIdx];
                int b = (currentSmallestIdx == i) ? j : i;
                v = (a < b) ? memo[a][b] : memo[b][a];
            } else {
                v = (currentSmallestIdx == i) ? j : i;
            }
            if (v == smallestIdx) {
                continue;
            }
            memoValues[currentSmallestIdx] = v;
        }
    }
    
    int[] result = new int[n];
    int count = 0;
    while (count < n) {
        result[count] = height[smallestIdx];
        smallestIdx = memoValues[smallestIdx];
        count++;
    }

    return result;
}



}


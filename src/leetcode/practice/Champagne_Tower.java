package leetcode.practice;

public class Champagne_Tower {
	
	public double champagneTower(int poured, int query_row, int query_glass) {
        if(query_glass>query_row) return 0.0;
        double [][]dp = new double[101][101];
        for(int i=0;i<101;i++) for(int j=0;j<101;j++) dp[i][j] = 0.0;
        
        dp[0][0] = poured;
         for(int i=1;i<101;i++){
             boolean flag = false;
             if(i==1 && poured > 1) flag = true;
              for(int j=0;j<=i;j++){
                  if(dp[i-1][j]>1){
                      double x = dp[i-1][j] - 1;
                      dp[i][j] = dp[i][j]+ (x/2);
                      dp[i][j+1] = dp[i][j+1]+ (x/2);
                      dp[i-1][j] = 1;
                      if(dp[i][j]>1) flag = true;
                      
//                      if(i==query_row && j==query_glass) return dp[i][j];
                  }
              }
             if(!flag) break;
         }
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++) System.out.print(dp[i][j]+" ");
             System.out.println();
        }
        return dp[query_row][query_glass];
    }

	public static void main(String[] args) {
		System.out.println(new Champagne_Tower().champagneTower(100000009, 33, 17));

	}

}

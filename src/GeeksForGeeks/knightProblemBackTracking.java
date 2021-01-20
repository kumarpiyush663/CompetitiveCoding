package GeeksForGeeks;
 

class knightProblemBackTracking{
  public static void printArray(int a[][], int N){
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        System.out.print(a[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static boolean validMove(int x, int y, int N, int visited[][]){
    if(x>=0 && x<N && y>=0 && y<N && visited[x][y]==-1) return true;
    return false;
  }
  public static void knightTour(int N){
    int visited[][]= new int[8][8];

    for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                visited[x][y] = -1;
    visited[0][0]=0;

     int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
     int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
//    int moves[][] = { { 2, 1 }, { 1, 2 }, { -2, -1 }, { -1, -2 }, { -1, 2 }, { -2, 1 }, { 2, -1 }, { 1, -2 } };
    // for(int i=0;i<8;i++){
    //
    //     System.out.print(moves[i][0]+", ");
    // }
    // System.out.println();
    // for(int i=0;i<8;i++){
    //
    //     System.out.print(moves[i][1]+", ");
    // }
    // System.out.println();
    int moveCount = 1;
    if(knightTourUTIL(visited, N, 0,  0, moveCount,xMove,yMove)) printArray(visited,N);
    else System.out.println("invalid");
    return;

  }
  public static boolean knightTourUTIL(int visited[][],int N,int x, int y, int moveCount , int xMove[],int yMove[]){

    if(moveCount == N*N) return true;

    for(int i=0;i<8;i++){
      if(validMove(x+xMove[i],y+yMove[i],N,visited)){
        visited[x+xMove[i]][y+yMove[i]] = moveCount;
        if(knightTourUTIL(visited, N, x+xMove[i],  y+yMove[i], moveCount+1,xMove,yMove)){
          return true;
        }
        else{
            visited[x+xMove[i]][y+yMove[i]] = -1;
        }

      }
    }
    return false;
  }
 public static void main(String[] args) {
   int[][] arr = { { 1, 2 }, { 3, 4 } };
   printArray(arr,2);
   int N=8;
   knightTour(N);
 }
}

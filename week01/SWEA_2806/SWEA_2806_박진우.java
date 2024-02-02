import java.util.*;

public class Solution {
    static int N;
    static int result;

    static boolean[][] getM(boolean[][] m, int x, int y) {
      boolean[][] newM = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (j == x || i == y // 가로세로
              || i-j == y-x // 대각선(좌상->우하)
              || i+j == y+x) { // 대각선(좌하->우상)
            newM[i][j] = true;
          }  else {
            newM[i][j] = m[i][j];
          }
        }
      }
      return newM;
    }
    
    static void queen(boolean[][] m, int y){
        if(y==N){
            result += 1;
            return;
        }
          for(int x=0; x<N; x++){
              if(!m[y][x]){ // 퀸 공격 범위가 아니면
                queen(getM(m, x, y), y+1); // 퀸 추가
              }
          }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t=1; t<=T; t++) {
          result = 0;
          N = sc.nextInt();
          boolean[][] m = new boolean[N][N]; // 퀸의 공격범위: true

          queen(m, 0);
          System.out.printf("#%d %d\n", t, result);
        }
    }
}   

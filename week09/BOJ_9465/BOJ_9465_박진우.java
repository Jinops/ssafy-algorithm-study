import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int T = Integer.parseInt(br.readLine());
    for(int t=1; t<=T; t++) {
      int n = Integer.parseInt(br.readLine());
      int[][] scores = new int[2][n]; 
      int[][] dp = new int[2][n]; // n번째 선택 했을 때
      
      for(int i=0; i<2; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++) {
          scores[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      
      dp[0][0] = scores[0][0];
      dp[1][0] = scores[1][0];
      
      if(n==1) {
        System.out.println(Math.max(dp[0][0], dp[1][0]));
        continue;
      }
      
      dp[0][1] = scores[0][1] + dp[1][0];
      dp[1][1] = scores[1][1] + dp[0][0];
      
      // OXO, XXO
      // XOX, OXX
      
      for(int i=2; i<n; i++) {
        dp[0][i] = scores[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
        dp[1][i] = scores[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
      }
      
      System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
    }
  }
}

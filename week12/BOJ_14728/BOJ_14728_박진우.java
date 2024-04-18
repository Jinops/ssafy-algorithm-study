import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken()); // 문제 개수
      int T = Integer.parseInt(st.nextToken()); // 총 시간
      
      int[] K = new int[N]; // 공부시간
      int[] S = new int[N]; // 점수
      int minK = 1000;
      
      for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        K[i] = Integer.parseInt(st.nextToken());
        S[i] = Integer.parseInt(st.nextToken());
        minK = Math.min(minK, K[i]);
      }

      // 방법 1
      int[][] dp = new int[N][T+1];
      
      for(int t=K[0]; t<=T; t++) {
        dp[0][t] = S[0];
      }
      
      for(int n=1; n<N; n++) {
        for(int t=minK; t<=T; t++) {
          if(t<K[n]) {
            dp[n][t] = dp[n-1][t];
          } else {
            dp[n][t] = Math.max(dp[n-1][t], S[n] + dp[n-1][t-K[n]]);
          }
        }
      }
      
      System.out.println(dp[N-1][T]);
      
      // 방법 2
      int[] dp2 = new int[T+1];
      for(int n=0; n<N; n++) {
        for(int t=T; t>=K[n]; t--) { 
          // dp를 거꾸로 안돌릴 경우, 중복이 가능해짐(동전 문제처럼)
          // ex) S[n]=40, K[n]=2일 때, 정방향 0 0 40 40 80 80 .. 
          // ex) S[n]=40, K[n]=2일 때, 역방향 0 0 40 40 40 40 ..
          dp2[t] = Math.max(dp2[t], S[n]+dp2[t-K[n]]);
        }
      }
      System.out.println(dp2[T]);
  }
}

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int N = Integer.parseInt(br.readLine());
    int[] T = new int[N+1]; // 걸리는 시간
    int[] P = new int[N+1]; // 금액
    
    int[] dp = new int[N+1]; // N일차 최대 수익
    
    for(int i=1; i<=N; i++) {
      st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    // i일차에 상담을 하면, T[i]일 동안은 상담을 못한다.
    // i일차 상담 -> i+T[i]-1일차에 종료됨

    // i+T[i]-1차의 최대 수익
    // - 원래 알고있던 dp[i+T[i]]
    // - i-1일차 최대수익에서 상담 i를 수행한 dp[i-1]+P[i]
    
    // 위처럼 끝나는 날의 수익을 먼저 설정하고, dp를 갱신해간다.
    // dp[i] = max(dp[i], dp[i-1])
    
    for(int i=1; i<=N; i++) {
      if(i+T[i]-1<=N){
        dp[i+T[i]-1] = Math.max(dp[i+T[i]-1], dp[i-1]+P[i]);
      }
      dp[i] = Math.max(dp[i], dp[i-1]);
    }

    System.out.println(dp[N]);
  }
}

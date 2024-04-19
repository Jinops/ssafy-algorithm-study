import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    
    int[] W = new int[N];
    int[] V = new int[N];
    int[][] dp = new int[N][K+1];
    int minW = 0;
    
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      W[i] = Integer.parseInt(st.nextToken());
      V[i] = Integer.parseInt(st.nextToken());
      minW = Math.min(minW, W[i]);
    }
    
    for(int w=W[0]; w<=K; w++) {
      dp[0][w] = V[0];
    }
    
    for(int n=1; n<N; n++) {
      for(int w=minW; w<=K; w++) {
        if(W[n] > w) { // 무게 초과하면
          dp[n][w] = dp[n-1][w];
        } else { // 초과안하면, 가치 + 이전꺼에서 용량뺀 뒤 가치
          dp[n][w] = Math.max(V[n] + dp[n-1][w-W[n]], dp[n-1][w]);
        }
      }
    }
    
    System.out.println(dp[N-1][K]);
  }
}

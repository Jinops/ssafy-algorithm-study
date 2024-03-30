import java.util.*;
import java.io.*;

public class Main {
  static int M, N;
  static int[][] map;
  static int[][] dp; // -1:방문x, 0:방문o, 1이상:해당 경로 통해 최종 갈 수 있는 경우
  static final int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
  
  static int dfs(int x, int y) {
    if(dp[y][x]!=-1) {
      return dp[y][x];
    }
    if(x==N-1 && y==M-1) {
      return 1;
    }
    dp[y][x]=0;
    
    for(int[] delta:deltas) {
      int nx = x+delta[0];
      int ny = y+delta[1];
      if(0<=nx && nx<N && 0<=ny && ny<M && map[y][x]>map[ny][nx]) {
          dp[y][x] += dfs(nx, ny);
        }
      }
    
    return dp[y][x]; // 더이상 가 곳 없을 때, 현재 dp값 출력. (최종적으론 0,0)
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new int[M][N];
    dp = new int[M][N];
    
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = -1;
      }
    };
    
    System.out.println(dfs(0 ,0));
  }
}

import java.util.*;
import java.io.*;

public class Solution {
  static int N;
  static double[][] P;
  
  static boolean[] visited;
  static double max;
  
  static void pick(int idx, double acc) {
    if(acc<max) {
      return;
    }
    if(idx==N) {
      max = acc;
      return;
    }
    
    for(int i=0; i<N; i++) {
      if(P[idx][i]!=0 && !visited[i]) {
        visited[i] = true;
        pick(idx+1, acc*P[idx][i]);
        visited[i] = false;
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int T = Integer.parseInt(br.readLine());
    for(int t=1; t<=T; t++) {
      
      N = Integer.parseInt(br.readLine());
      P = new double[N][N];
      visited = new boolean[N];
      max = 0;
      
      for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
          P[i][j] = Double.parseDouble(st.nextToken())/100.0;
        }
      }
      
      pick(0, 1);
      
      System.out.printf("#%d %.6f\n", t, max*100);
    }
  }
}

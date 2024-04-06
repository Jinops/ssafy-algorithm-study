// 크루스칼 (배열 구현)
// 다익스트라x : 한 점으로부터 최단거리를 구하는 알고리즘인데, 
// 이 문제의 경우 모든 점을 이은 최단거리 구하는 문제이므로 부적절
import java.util.*;
import java.io.*;

public class Main {
  static int N;
  
  static int[] ps = new int[N];
  
  static int findParent(int x) {
    if(ps[x]!=x) {
      ps[x] = findParent(ps[x]);
    }
    return ps[x];
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    N = Integer.parseInt(br.readLine());
    int[][] edges = new int[N*N][3]; // from-to-cost
    ps = new int[N];
    
    for(int i=0; i<N; i++) {
      ps[i] = i;
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++) {
        int cost = Integer.parseInt(st.nextToken());
        edges[i*N+j] = new int[]{i, j, cost};
      }
    }
    
    Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);
    
    int pick = 0;
    int idx = 0;
    long result = 0;
    
    while(pick < N-1) {
      int[] edge = edges[idx++];
      
      int p1 = findParent(edge[0]);
      int p2 = findParent(edge[1]);
      if(p1==p2) continue;
      
      ps[p2] = p1;
      pick += 1;
      result += edge[2];
    }
    
    System.out.println(result);
  }
}

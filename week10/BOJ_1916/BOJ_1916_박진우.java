import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
  int n;
  int cost;
  
  public Node(int target, int cost) {
    this.n = target;
    this.cost = cost;
  }

  @Override
  public int compareTo(Node o) {
    return this.cost - o.cost;
  }
  
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    
    List<Node>[] nodes = new ArrayList[N+1];
    boolean[] visited = new boolean[N+1];
    int[] dists = new int[N+1]; // 원점으로부터의 거리
    
    for(int i=1; i<=N; i++) {
      nodes[i] = new ArrayList<>();
      dists[i] = Integer.MAX_VALUE;
    }
    
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      
      nodes[from].add(new Node(to, cost));
    }
    
    st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(A, 0));
    dists[A] = 0;
    
    while(!pq.isEmpty() && !visited[B]) {
      Node node = pq.poll();
      
      if(visited[node.n]) {
        continue;
      }
      visited[node.n] = true; // 비용 확정
      
      for(Node next:nodes[node.n]) {
        if(visited[next.n]) {
          continue;
        }
        
        int newDist = dists[node.n] + next.cost;
        // node n을 거쳐서 next를 가는 거리
        if(newDist < dists[next.n]) {
          // 기존에 알고 있던 거리보다 가까운 거리라면
          dists[next.n] = newDist; 
          pq.add(new Node(next.n, dists[next.n]));
          // pq.add(next) 아닌 이유: 다익스트라는 최초 시작점으로부터의 거리이다.
        }
      }
    }
    
    System.out.println(dists[B]);
  }
}

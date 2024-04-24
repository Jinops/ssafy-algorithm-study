import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
  int n;
  int dist;
  
  Node(int n, int dist){
    this.n = n;
    this.dist = dist;
  }

  @Override
  public int compareTo(Node o) {
    return this.dist - o.dist;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    List<Node>[] nodes = new List[N+1];
    for(int i=1; i<=N; i++) {
      nodes[i] = new ArrayList<>();
    }
    
    for(int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      
      nodes[from].add(new Node(to, cost));
      nodes[to].add(new Node(from, cost));
    }
    
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      
      int result = -1;
      
      PriorityQueue<Node> pq = new PriorityQueue<>();
      boolean[] visited = new boolean[N+1];
      
      pq.add(new Node(from, 0));
      visited[from] = true;
      
      while(!pq.isEmpty()) {
        Node node = pq.poll();
        if(node.n == to) {
          result = node.dist;
          break;
        }
        
        for(Node next:nodes[node.n]) {
          if(visited[next.n]) continue;
          visited[next.n] = true;
          pq.add(new Node(next.n, node.dist+next.dist));
        }
      }
      
      System.out.println(result);
    }
  }
}

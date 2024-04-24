import java.util.*;
import java.io.*;

class Node {
  int n;
  int dist;
  
  Node(int n, int dist) {
    this.n = n;
    this.dist = dist;
  }
}

public class Main {
  static List<Node>[] nodes;
  
  static void DFS(int n, boolean[] visited, int dist, Node data, int exclude) {
    for(Node next:nodes[n]) {
      if(visited[next.n]) continue;
      visited[next.n] = true;
      DFS(next.n, visited, dist+next.dist, data, exclude);
      visited[next.n]= false; 
    }
    
    if(dist>data.dist) {
      if(n==exclude) return;
      data.n = n;
      data.dist = dist;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int V = Integer.parseInt(br.readLine());
    nodes = new ArrayList[V+1];
    
    for(int i=1; i<=V; i++) {
      nodes[i] = new ArrayList<>();
    }
    
    for(int i=0; i<V; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      
      while(to!=-1) {
        int dist = Integer.parseInt(st.nextToken());
        
        nodes[from].add(new Node(to, dist));

        to = Integer.parseInt(st.nextToken());
      }
    }
    
    Node data = new Node(1, 0); // 임의의 노드
    boolean visited[] = new boolean[V+1];
    visited[1] = true;
    
    DFS(data.n, visited, 0, data, 0);
    
    data.dist = 0;
    visited = new boolean[V+1];
    visited[data.n]= true; 
    
    DFS(data.n, new boolean[V+1], 0, data, data.n);
    
    System.out.println(data.dist);
  }
}

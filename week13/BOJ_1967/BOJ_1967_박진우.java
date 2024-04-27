// try 1. 다익스트라 : 리프노드 간의 거리를 구하려 했으나, 트리에서 한 경로에 대해 거리가 갱신될 필요가 없으므로, 비효율
// try 2. DFS: 루트노드로부터 가장 먼 A 노드에 대해, A로부터 가장 먼 B 노드까지의 거리를 구한다.
// 그림(원)을 보면, 루트노드로부터 가장 먼 노드 A로부터, 가장 먼 노드 B의 거리가 곧 지름이다.

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
  static List<Node>[] nodes;
  
  static void DFS(int n, boolean[] visited, int dist, Node data, int exclude) {
    
    for(Node next:nodes[n]) {
      if(visited[next.n]) continue;
      visited[next.n] = true;
      DFS(next.n, visited, dist+next.dist, data, exclude);
      visited[next.n]= false; 
    }
    
    
    if(dist > data.dist) {
      if(n==exclude) return;
      data.n = n;
      data.dist = dist;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int N = Integer.parseInt(br.readLine());
    nodes = new List[N+1];
    
    for(int i=1; i<=N; i++) {
      nodes[i] = new ArrayList<>();
    }
    
    for(int i=0; i<N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());
      
      nodes[from].add(new Node(to, dist));
      nodes[to].add(new Node(from, dist));
    }
    
    Node data = new Node(1, 0);
    boolean[] visited = new boolean[N+1];
    visited[data.n] = true;
    
    DFS(data.n, new boolean[N+1], 0, data, 0);
    
    data.dist = 0;
    visited = new boolean[N+1];
    visited[data.n] = true;
    
    DFS(data.n, new boolean[N+1], 0, data, data.n);
    
    System.out.println(data.dist);
  }
}

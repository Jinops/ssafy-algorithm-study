// 다익스트라 변형
// dists에 저장하는 값: 원점에서부터 해당 지점까지 버티는 최소 무게
// 정렬 및 pq 추가 기준: 버티는 무게가 큰 것 부터

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
  int n;
  int weight;
  
  public Node(int n, int cost) {
    this.n = n;
    this.weight = cost;
  }
  
  @Override
  public int compareTo(Node o) {
    // 내림차순
    return o.weight - this.weight;
  }
}

public class Main {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    List<Node>[] edges = new List[N+1];
    for(int i=1; i<=N; i++) {
      edges[i] = new ArrayList<>();
    }
    
    for(int m=0; m<M; m++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      
      edges[A].add(new Node(B, cost));
      edges[B].add(new Node(A, cost));
    }
    
    int result = Integer.MAX_VALUE;
    
    st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    
    boolean[] confirmed = new boolean[N+1];
    int[] dists = new int[N+1];
    Arrays.fill(dists, Integer.MIN_VALUE);
    
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dists[A] = 0;
    pq.add(new Node(A, 0));
    
    while(!pq.isEmpty()) {
      Node node = pq.poll();
      
      if(confirmed[node.n]) continue;
      
      confirmed[node.n]= true;
      if(node.n!=A) result = Math.min(result, node.weight);
      if(node.n==B) break;
      
      for(Node next:edges[node.n]) {
        if(confirmed[next.n]) continue;
        int newDist = (node.n!=A)? Math.min(dists[node.n], next.weight) : next.weight;
        if(newDist > dists[next.n]) {
          dists[next.n] = newDist; 
          pq.add(new Node(next.n, newDist));
        }
      }
    }
    
    System.out.println(result);
  }
}

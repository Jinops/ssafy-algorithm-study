package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

	int v;
	int cost;

	public Edge(int v, int cost) {
		super();
		this.v = v;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Edge [v=" + v + ", cost=" + cost + "]";
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.cost, o.cost);
	}

}

public class BOJ_1916_김명화 {

	static int N, M, start, end, cost;
	static List<Edge>[] adj;
	static boolean[] visited;
	static int[] costs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		costs = new int[N+1];
		
		for(int i=0; i<adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			adj[A].add(new Edge(B,C));
		} // 인접 리스트
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		Arrays.fill(costs, Integer.MAX_VALUE); // 무한대로 초기화
		costs[start] = 0;
		dijkstra(start);
		
		System.out.println(costs[end]);

	}

	private static void dijkstra(int start) {
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			
			Edge curr = pq.poll();
			
			if(visited[curr.v]) continue; //이미 방문
			
			visited[curr.v] = true;
			
			for(Edge e : adj[curr.v]) {
				
				if(!visited[e.v] && costs[e.v] > costs[curr.v] + e.cost) {
					costs[e.v] = costs[curr.v] + e.cost;
					pq.offer(new Edge(e.v, costs[e.v]));
				}
				
				
			}
			
			if(curr.v==end) break;
			
			
		}
		
	}

}

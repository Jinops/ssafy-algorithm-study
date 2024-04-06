package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16398_행성_연결 {

	static int N;	// 행성의 개수
	static List<Edge>[] adjList;
	static PriorityQueue<Edge> pq;
	static boolean[] visit;
	static int[][] adj;	// 인접 행렬
	static int[][] edges;
	static long cost;	// 관리비용
	
	static class Edge implements Comparable<Edge>{

		int st, ed, w;
		
		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}		
	}	// Edge 클래스
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[N];
		for (int i = 0; i < N; i++) adjList[i] = new ArrayList<>();
		
		adj = new int[N][N];
		for (int r = 0; r < N; r++) {
			
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) 
				adj[r][c] = Integer.parseInt(st.nextToken());
		}	// adj배열 완성
		
		for (int r = 0; r < N; r++) 
			for (int c = 0; c < N; c++) {
				if (r == c) continue;
				adjList[r].add(new Edge(r, c, adj[r][c]));
			}
		
		visit = new boolean[N];
		visit[0] = true;

		pq = new PriorityQueue<>();
		pq.addAll(adjList[0]);
		
		int pick = 1;
		cost = 0;
		
		while (pick != N) {
			
			Edge e = pq.poll();
			
			if (visit[e.ed]) continue;
			
			cost += e.w;
			visit[e.ed] = true;
			pick++;
			
			pq.addAll(adjList[e.ed]);
		}	// while문
		
		System.out.println(cost);
	}
}
























































package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용_구하기 {

	static int N, M;	// 도시의 개수, 버스의 개수
	static List<Node>[] adj;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	static boolean[] visit;
	static int Start, End;	// 출발 도시, 도착, 도시
	
	static class Node {
		
		int v, w;	// 도착 정점, 가중치
		
		public Node (int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) 
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(end, weight));
		}	// i에 대한 for문
		
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
		st = new StringTokenizer(br.readLine());
		Start = Integer.parseInt(st.nextToken());
		End = Integer.parseInt(st.nextToken());
		
		Dijkstra(Start);
		
		System.out.println(dist[End]);
	}	// main

	private static void Dijkstra(int st) {
		
		visit = new boolean[N + 1];
		dist[st] = 0;	// 시작 노드까지의 거리는 0
		
		for (int i = 0; i < N - 1; i++) {
			
			int min = INF;
			int idx = 0;	// 0대신 -1을 하면 안되는 이유???
			
			for (int j = 1; j < N + 1; j++) {
				
				if (!visit[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			visit[idx] = true;
			
			for (Node node : adj[idx]) {
				if (!visit[node.v] && dist[node.v] > dist[idx] + node.w)
					dist[node.v] = dist[idx] + node.w;
			}
		}
	}	// Dijkstra
}
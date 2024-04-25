package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
	int end;
	int dis;

	public Edge(int end, int dis) {
		super();
		this.end = end;
		this.dis = dis;
	}

}

public class 노드사이의거리 {

	static int N, M;
	static List<Edge>[] tree;
	static boolean[] visited ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new ArrayList[N+1]; // 1-based

		for (int i = 1; i <= N ; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			tree[a].add(new Edge(b, c));
			tree[b].add(new Edge(a, c));
		}
		
		for(int m=0; m<M; m++) {
			visited = new boolean[N+1]; // 방문배열 초기화
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			sb.append(getDistance(node1, node2, 0)+"\n");
		}
		System.out.println(sb);
	}
	
	static int getDistance(int current, int target, int distance) {
		
		// base condition
		visited[current] =true;
		if(target == current) return distance;
		
		// recursive condition
		for(Edge e: tree[current]) {
			if(!visited[e.end]) {
				int dist = getDistance(e.end, target, distance + e.dis);
				if(dist!=-1) return dist;
			}
		}
		
		return -1; // 이 경로에서 목표를 찾지 못한다. 
	}

}

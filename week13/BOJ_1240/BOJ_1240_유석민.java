package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1240_노드사이의_거리 {
	
	static int N, M;	// 노드의 개수, 거리를 알고 싶은 노드 쌍의 개수
	static List<Node>[] list;	// 
	static List<int[]> nodeNum;	// 거리를 알고 싶은 노드 쌍을 담을 배열
	static boolean[] visit;	// 방문배열
	static int ans;
	
	static class Node {
		
		int next;
		int dist;
		
		Node (int next, int dist){
			this.next = next;
			this.dist = dist;
		}
	}	// Node class
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < N - 1; i++) {
			
			st = new StringTokenizer(br.readLine());
			int no1 = Integer.parseInt(st.nextToken());
			int no2 = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			// 두 노드 사이에 방향성이 존재하지 않으므로 노드1에 노드2를, 노드2에 노드1을 연결한다.
			list[no1].add(new Node(no2, dis));
			list[no2].add(new Node(no1, dis));
		}	// 노드 사이의 거리를 입력받음
		
		nodeNum = new ArrayList<int[]>();
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			nodeNum.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		for (int i = 0; i < nodeNum.size(); i++) {
			
			int[] node = nodeNum.get(i);
			
			visit = new boolean[N + 1];
			// 시작 노드, 목적 노드, 현재 이동 거리
			DFS(node[0], node[1], 0);
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}	// main

	private static void DFS(int from, int to, int distance) {

		// 이전 노드와 연결되어 있던 노드가 목적지 노드라면 DFS 메소드를 종료
		if (from == to) {
			
			ans = distance;
			return;
		}
		
		// 방문처리를 하지 않으면 두 개의 노드만 무한히 왔다갔다 할 수 있으므로 방문처리 
		visit[from] = true;
		
		for (int i = 0; i < list[from].size(); i++) {
			
			// 연결되어 있는 노드가 방문하지 않은 노드인 경우 방문
			if (!visit[list[from].get(i).next])
				DFS(list[from].get(i).next, to, distance + list[from].get(i).dist);
		}
	}	// DFS
}
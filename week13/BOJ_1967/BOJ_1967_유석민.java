package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967_트리의_지름 {

	static int N;
	static List<Node>[] list;
	static boolean[] visit;
	static boolean[] hasChi;
	static int ans = 0;
	
	static class Node {
		
		int link;
		int weight;
		Node (int link, int weight){
			this.link = link;
			this.weight = weight;
		}
	}	// Node class
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			list[i] = new ArrayList<>();
		
		hasChi = new boolean[N + 1];
		for (int i = 1; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			hasChi[A] = true;
			list[A].add(new Node(B, D));
			list[B].add(new Node(A, D));
		}	// 트리 정보 완성
		
		for (int i = 1; i < N + 1; i++) {
			
			visit = new boolean[N + 1];
			if (!hasChi[i])	// 자식이 없는 리프 노드에서 DFS시작
				DFS(i, 0);
		}
		
		System.out.println(ans);
	}	// main

	private static void DFS(int num, int distance) {

		boolean flag = true;
		for (int i = 0; i < list[num].size(); i++) {
			
			if (!visit[list[num].get(i).link]) {
				flag = false;
			}
		}
		
		if (flag) {
			ans = Math.max(ans, distance);
			return;
		}
		
		visit[num] = true;
		for (int i = 0; i < list[num].size(); i++) {
			if (!visit[list[num].get(i).link]) {
				
				visit[list[num].get(i).link] = true;
				DFS(list[num].get(i).link, distance + list[num].get(i).weight);
			}
		}
	}	// DFS
}

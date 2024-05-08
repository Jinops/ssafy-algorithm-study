package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939_중량제한 {

	static int N, M;
	static List<Node>[] list;
	static boolean[] visit;
	static Queue<Integer> queue;
	static int A, B, W;
	static int max, min, ans;
	static int sta, ed;
	
	static class Node {
		
		int num;
		int weight;
		
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}	// Node class
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			list[A].add(new Node(B, W));
			list[B].add(new Node(A, W));
			
			max = Math.max(max, W);
			min = Math.min(min, W);
		}	// i에 대한 for문
		
		st = new StringTokenizer(br.readLine());
		sta = Integer.parseInt(st.nextToken());	// 시작
		ed = Integer.parseInt(st.nextToken());	// 끝
			
		ans = 0;
		while (max >= min) {
			
			int mid = (max + min) / 2;
			visit = new boolean[N + 1];
			
			if (BFS(mid)) {
				min = mid + 1;
				ans = mid;
			} else {
				max = mid - 1;
			}
		}	// while문
		
		System.out.println(ans);
	}	// main

	private static boolean BFS(int mid) {
		
		queue = new LinkedList<Integer>();
		queue.add(sta);
		visit[sta] = true;
		
		while (!queue.isEmpty()) {
			int next = queue.poll();
			
			if (next == ed)
				return true;
			
			for (int i = 0; i < list[next].size(); i++) {
				if(list[next].get(i).weight>= mid && !visit[list[next].get(i).num]) {
					
                    visit[list[next].get(i).num] = true;
                    queue.add(list[next].get(i).num);
                }
			}
		}	// while문
		
		return false;
	}	// BFS
}

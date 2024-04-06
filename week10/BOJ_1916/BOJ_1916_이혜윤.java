package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	
	int to;
	int cost;

	public Node(int to, int cost) {
		super();
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node node) {
		return Integer.compare(this.cost, node.cost);
	}
	
}

public class 최소비용구하기 {
	
	static List<ArrayList<Node>> nodeList = new ArrayList<>();
	static boolean[] visited;
	static int[] dist;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<=N; i++) {
			nodeList.add(new ArrayList<>());
		}
		
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int startNum = Integer.parseInt(st.nextToken());
			int endNum = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			nodeList.get(startNum).add(new Node(endNum, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end =Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start, end));
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N+1];
		pq.offer(new Node(start, 0));
		dist[start] =0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curTo = curNode.to;
			
			if(!check[curTo]) {
				check[curTo] = true;
				
				for(Node node: nodeList.get(curTo)) {
					if(!check[node.to] && dist[node.to]> dist[curTo]+ node.cost ){
						dist[node.to] = dist[curTo] + node.cost;
						pq.add(new Node(node.to, dist[node.to]));
					}
				}
			}
		}
		return dist[end];
		
		
	}

}
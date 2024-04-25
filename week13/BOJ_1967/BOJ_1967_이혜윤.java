package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node{
	
	int end;
	int weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
}


public class 트리의지름 {
	
	static int N;
	static boolean[] visited;
	static ArrayList<Node>[] nodeList;
	static int maxDis = 0;
	static int maxNode;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nodeList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) nodeList[i] = new ArrayList<>();
		
		if (N == 1) {
            System.out.println(0); // 노드가 하나만 있을 경우 지름은 0입니다.
            return;
        }
		
		
		for(int n=1; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList[from].add(new Node(to, weight));
			nodeList[to].add(new Node(from, weight));
		}
		
		visited = new boolean[N+1];
		dfs(1, 0);
		
		visited = new boolean[N+1];
		dfs(maxNode, 0);
		
		System.out.println(maxDis);
	}


	private static void dfs(int x, int dis) {
		visited[x] = true;

		if(dis> maxDis) {
			maxNode = x;
			maxDis = dis;
		}
		
		for(int i=0; i<nodeList[x].size(); i++) {
			Node cur = nodeList[x].get(i);
			if(!visited[cur.end]) {
				dfs(cur.end, cur.weight+dis);
			}
		}
	}

}

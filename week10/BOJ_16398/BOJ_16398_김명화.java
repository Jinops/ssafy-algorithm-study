package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Info implements Comparable<Info> {

	int v;
	long w;

	public Info(int v, long w) {
		super();
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Info o) {
		return Long.compare(this.w, o.w);
	}

	@Override
	public String toString() {
		return "Info [v=" + v + ", w=" + w + "]";
	}

}

public class BOJ_16398_김명화 {

	static int N;
	static Long[][] planet;
	static boolean[] visited;
	static List<Info>[] adj;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		planet = new Long[N][N];
		visited = new boolean[N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				planet[r][c] = Long.parseLong(st.nextToken());
			}
		}

		adj = new ArrayList[N];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int r = 0; r < N; r++) {
			for (int c = r + 1; c < N; c++) {
				adj[r].add(new Info(c, planet[r][c]));
				adj[c].add(new Info(r, planet[r][c]));
			}
		}
		

		prim(0);

	}

	private static void prim(int i) {

		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.addAll(adj[i]);
		visited[i] = true;

		int pick = 1;
		long res = 0;

		while (pick != N) {

			Info curr = pq.poll();
			
			if(visited[curr.v]) continue;
			
			visited[curr.v] = true;
			pick ++;
			res+=curr.w;
			
			pq.addAll(adj[curr.v]);

		}
		
		System.out.println(res);

	}

}

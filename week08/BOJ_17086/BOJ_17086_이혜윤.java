package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark {
	int r;
	int c;
	int dis;

	public Shark(int r, int c, int dis) {
		super();
		this.r = r;
		this.c = c;
		this.dis = dis;
	}
}

public class 아기상어2 {

	static int N, M;
	static int[][] map;
	static int[][] safeDistance;
	static int[] dr = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 0, 0, 1, -1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		safeDistance = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		int maxDis = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(map[n][m]==1) continue;
				int dis = BFS(n,m);
				maxDis = Math.max(maxDis, dis);
			}
		}
		System.out.println(maxDis);
	}

	static int BFS(int r, int c) {
		boolean visit[][] = new boolean[N][M];
		Queue<Shark> q = new LinkedList<>();
		
		q.add(new Shark(r,c,0));
		visit[r][c]= true;
		
		while(!q.isEmpty()) {
			Shark cur = q.poll();
			
			for(int d=0; d<8; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
			
				
				if(isPossible(nr, nc)&& !visit[nr][nc]) {
						if(map[nr][nc]==1) {
							return cur.dis+1;
						} 
						visit[nr][nc] = true;
						q.add(new Shark(nr, nc, cur.dis+1));
				}
				
			}
		}
		return 0;
	}

	static boolean isPossible(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M)
			return false;
		return true;
	}
}

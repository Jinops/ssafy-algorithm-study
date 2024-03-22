import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {

	int r;
	int c;
	int n;

	public Pair(int r, int c, int n) {
		super();
		this.r = r;
		this.c = c;
		this.n = n;
	}

}

public class BOJ_17086_김명화 {

	static int N;
	static int M;
	static int shark[][];
	static boolean visited[][];
	static int[] dr = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dc = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		shark = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				shark[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (shark[r][c] == 0) {

					int res = bfs(r, c);
					max = Math.max(max, res);

				}

			}

		}

		System.out.println(max);

	}

	private static int bfs(int r, int c) {

		visited = new boolean[N][M];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(r, c, 0));
		visited[r][c] = true;

		while (!q.isEmpty()) {

			Pair currP = q.poll();
			int currR = currP.r;
			int currC = currP.c;
			
			for (int d = 0; d < 8; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];
								
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) { // 범위에 있고 방문을 안 했을 때
					
					
					if (shark[nr][nc] == 1) {
						return currP.n+1;
					} else {
						q.add(new Pair(nr, nc, currP.n+1));
						visited[nr][nc] = true;

					}

				}

			}
			
		}
		
		return 0;

	}

}

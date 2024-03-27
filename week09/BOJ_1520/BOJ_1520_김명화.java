
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1520_김명화 {

	static int M;
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dr = { 0, 0, -1, 1};
	static int[] dc = { -1, 1, 0, 0};
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		dp = new int[M][N];

		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				dp[r][c] = -1; 
			}
		}

		System.out.println(dfs(0, 0));

	}

	public static int dfs(int r, int c) {

		// 도착지점에 도달했다면
		if (r == M - 1 && c == N - 1)
			return 1;

		// 이미 방문했다면 반환
		if (dp[r][c] != -1)
			return dp[r][c];

		// 방문체크
		dp[r][c] = 0;
		int k = map[r][c];

		for (int d = 0; d < 4; d++) {

			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && map[nr][nc] < k) {

				dp[r][c] += dfs(nr, nc); // 현재 칸에서 도착 지점까지의 경로의 수를 더한다

			}

		}
		
		return dp[r][c]; // 현재 칸에서 도착 지점까지의 경로의 수,,

	}

	public static boolean check(int r, int c) {

		return r >= 0 && r < M && c >= 0 && c < N;
	}

}

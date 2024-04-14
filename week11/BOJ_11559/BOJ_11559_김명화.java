package week11;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11559_김명화 {

	static int N = 12;
	static int M = 6;
	static char[][] puyo;
	static boolean[][] visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		puyo = new char[N][M];

		for (int r = 0; r < N; r++) {
			String puyos = br.readLine();
			for (int c = 0; c < M; c++) {
				puyo[r][c] = puyos.charAt(c);
			}
		}

		int ans = 0; // 연쇄 횟수

		while (true) {

			visited = new boolean[N][M]; // 뿌요 새로 시행 시 초기화
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visited[r][c] && puyo[r][c] != '.') {

						if (bfs(r, c)) {
							cnt++;
						}
					}
				}
			}

			if (cnt == 0)
				break;
			ans++;
			drop();

		}

		System.out.println(ans);

	}

	private static boolean bfs(int r, int c) {

		Queue<Point> q = new LinkedList<>();
		List<Point> list = new ArrayList<>();
		q.offer(new Point(r, c));
		char color = puyo[r][c];
		visited[r][c] = true;
		list.add(new Point(r,c));

		while (!q.isEmpty()) {

			Point curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.x + dr[d];
				int nc = curr.y + dc[d];

				if (check(nr, nc) && !visited[nr][nc] && puyo[nr][nc] == color) {
					q.offer(new Point(nr, nc));
					visited[nr][nc] = true;
					list.add(new Point(nr, nc));

				}
			}

		}

		if (list.size() >= 4) {
			clear(list);
			return true;
		}

		return false;

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < 12 && c >= 0 && c < 6;
	}

	private static void clear(List<Point> list) {

		for (Point p : list) {
			puyo[p.x][p.y] = '.';
		}
	}

	private static void drop() {

		for (int c = 0; c < 6; c++) {
			for (int r = 11; r >= 0; r--) {

				if (puyo[r][c] != '.') {

					int curr = r;
					while (true) {
						curr++;
						if (check(curr, c) && puyo[curr][c] == '.') {
							puyo[curr][c] = puyo[curr - 1][c];
							puyo[curr - 1][c] = '.';
						} else {
							break;
						}

					}

				}

			}

		}
	}
}

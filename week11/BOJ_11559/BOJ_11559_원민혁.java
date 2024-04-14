import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11559_PuyoPuyo {
	static char[][] map;
	static boolean[][] visited;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int stage = 0;
		do {
			check = false;
			visited = new boolean[12][6];
			for (int r = 11; r >= 0; r--) {
				for (int c = 0; c < 6; c++) {
					if (map[r][c] != '.' && !visited[r][c]) {
						if (bfs(r, c, map[r][c]))
							check = true;
					}
				}
			}
			for (int c = 0; c < 6; c++) {
				for (int r = 11; r >= 0; r--) {
					if (map[r][c] != '.') {
						int nr = r;
						while (nr < 11 && map[nr + 1][c] == '.') {
							nr++;
						}
						if (nr != r) {
							map[nr][c] = map[r][c];
							map[r][c] = '.';
						}
					}
				}
			}
			stage++;
		} while (check);

		System.out.println(stage-1);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static boolean bfs(int row, int column, char c) {
		List<int[]> list = new ArrayList<>(); // 지나간 것들 담는 리스트
		Queue<int[]> queue = new LinkedList<>();
		visited[row][column] = true;
		queue.offer(new int[] { row, column });
		list.add(new int[] { row, column });
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && map[nr][nc] == c && !visited[nr][nc]) {
					queue.offer(new int[] { nr, nc });
					list.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
		if (list.size() >= 4) {
			for (int[] arr : list) {
				map[arr[0]][arr[1]] = '.';
			}
			return true;
		} else
			return false;
	}
}

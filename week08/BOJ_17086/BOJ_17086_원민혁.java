import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17086 {
	static int n;
	static int m;
	static boolean[][] map;
	static boolean[][] visited;
	static int[][] distanceMap;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		distanceMap = new int[n][m];
		List<int[]> coordinate = new ArrayList<>();
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = st.nextToken().equals("1");
				if (map[r][c])
					coordinate.add(new int[] { r, c });
			}
		}
		for (int i = 0; i < coordinate.size(); i++) {
			int[] set = coordinate.get(i);
			checkSafeDistance(set);
		}
		int maxDistance = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (maxDistance < distanceMap[r][c])
					maxDistance = distanceMap[r][c];
			}
		}
		System.out.print(maxDistance);
	}

	private static void checkSafeDistance(int[] set) {
		visited = new boolean[n][m];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(set);
		int distance = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			distance++;
			for (int s = 0; s < size; s++) {
				int[] tmp = queue.poll();
				int r = tmp[0];
				int c = tmp[1];
				for (int i = 0; i < 8; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && !map[nr][nc]) {
						visited[nr][nc] = true;
						if (distanceMap[nr][nc] == 0) {
							distanceMap[nr][nc] = distance;
							queue.offer(new int[] { nr, nc });
						} else if (distanceMap[nr][nc] != 0 && distanceMap[nr][nc] > distance) {
							distanceMap[nr][nc] = distance;
							queue.offer(new int[] { nr, nc });
						}
					}
				}
			}
		}
	}
}

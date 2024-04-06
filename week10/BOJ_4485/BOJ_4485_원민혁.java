import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_4485_녹색옷입은애가젤다지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testNum = 1;
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			sb.append("Problem " + testNum + ": ");
			testNum++;
			int[][] map = new int[n][n];
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			pq.offer(new int[] {0, 0, map[0][0]});
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, 1, -1};
			int result = -1;
			boolean[][] visited = new boolean[n][n];
			while (!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int r = tmp[0];
				int c = tmp[1];
				int w = tmp[2];
				visited[r][c] = true;
				if (visited[n-1][n-1]) {
					result = w;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
						pq.offer(new int[] {nr, nc, w + map[nr][nc]});
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16398_행성연결 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 행성 수

		int[][] map = new int[N][N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

		boolean[] visited = new boolean[N];
		int peek = 0;
		pq.offer(new int[] { 0, 0 });
		long result = 0L;
		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int cur = tmp[0]; // 출발점 위치
			int w = tmp[1];
			if (visited[cur]) {
				continue;
			}
			result += w;
			visited[cur] = true;
			peek++;
			if (peek >= N) {
				break;
			}
			for (int i = 0; i < N; i++) {
				if (!visited[i] && i != cur) {
					pq.offer(new int[] { i, map[cur][i] });
				}
			}
		}
		System.out.println(result);
	}
}

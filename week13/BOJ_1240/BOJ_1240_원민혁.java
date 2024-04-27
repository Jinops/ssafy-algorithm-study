import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1240_노드사이의거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 노드의 수
		int M = Integer.parseInt(st.nextToken()); // 거리를 알고 싶은 노드 쌍의 개수
		List<int[]>[] map = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 연결 점1
			int b = Integer.parseInt(st.nextToken()); // 연결 점2
			int w = Integer.parseInt(st.nextToken()); // 거리
			map[a].add(new int[] {b, w});
			map[b].add(new int[] {a, w});
		}
		Integer[][] visited = new Integer[N+1][N+1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			
			if (visited[start][goal] != null) { // 한 번이라도 갔던 곳이라면 저장되어 있음.
				sb.append(visited[start][goal]).append("\n");
				continue;
			}
			visited[start][start] = 0;
			Queue<int[]> queue = new LinkedList<>();
			for (int j = 0; j < map[start].size(); j++) {
				queue.offer(map[start].get(j));
				visited[start][map[start].get(j)[0]] = map[start].get(j)[1];
			}
			
			while(!queue.isEmpty()) {
				int[] tmp = queue.poll();
				for (int j = 0; j < map[tmp[0]].size(); j++) {
					int[] t = map[tmp[0]].get(j); // 도착하는 곳, 거리 
					if (visited[start][t[0]] == null) {
						visited[start][t[0]] = visited[start][tmp[0]] + t[1];
						queue.offer(new int[] {t[0], visited[start][t[0]]});
					}
				}
			}
			sb.append(visited[start][goal]).append("\n");
		}
		System.out.print(sb);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_김명화 {

	static int N;
	static int[] population;
	static ArrayList<Integer>[] list;
	static boolean[] sel; // 부분집합 재귀
	static boolean[] visited; // bfs
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		sel = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N + 1; i++) { // 인구수 배열
			population[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[N + 1]; // 인접리스트
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}


		vote(1);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);

	}

	public static void vote(int idx) {

		// 기저 조건
		if (idx >= N + 1) { // 부분집합이 만들어졌을 때
			
			// 하나라도 true가 없으면 return
			boolean flag = false;
			for(int i=1; i<sel.length; i++) {
				if(sel[i]) {
					flag = true;
					break;
				}
			}
			if(!flag) return;
			
			// 가능, 불가능 따지기
			// bfs 한 번씩만 수행
			visited = new boolean[N + 1];

			for (int i = 1; i < N + 1; i++) {
				if (sel[i]) {
					bfs(i, true);
					break;
				}
					
			}

			for (int i = 1; i < N + 1; i++) {
				if (!sel[i] && !visited[i]) {
					bfs(i, false);
					break;
				}
			}
			
			// 이걸 다 마쳤을 때 visited가 다 true로 체크되어 있어야
			for (int i = 1; i < visited.length; i++) {
				if (!visited[i])
					return;
			}
			
			// 여기를 통과했다면 각 부분집합별 합의 차이 구해서 저장
			int selT = 0;
			int selF = 0;

			for (int i = 1; i < sel.length; i++) {
				if (sel[i])
					selT += population[i];
				else
					selF += population[i];
			}

			min = Math.min(min, Math.abs(selT - selF));
			return;

		}

		sel[idx] = true;
		vote(idx + 1);

		sel[idx] = false;
		vote(idx + 1);

	}

	public static void bfs(int i, boolean tf) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visited[i] = true;

		while (!q.isEmpty()) {

			int now = q.poll();

			for (int n : list[now]) {

				if (!visited[n] && sel[n] == tf) {
					q.offer(n);
					visited[n] = true;

				}

			}

		}

	}

}

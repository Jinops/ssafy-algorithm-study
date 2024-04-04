package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

	int r;
	int c;
	int v;

	public Node(int r, int c, int v) {
		super();
		this.r = r;
		this.c = c;
		this.v = v;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.v, o.v);
	}

	@Override
	public String toString() {
		return "Node [r=" + r + ", c=" + c + ", v=" + v + "]";
	}

}

public class BOJ_4485_김명화 {

	static int N;
	static int[][] cave;
	static int[][] loss;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 1;
		while ((N = Integer.parseInt(br.readLine())) != 0) {

			cave = new int[N][N];
			loss = new int[N][N];

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					cave[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				Arrays.fill(loss[i], Integer.MAX_VALUE);
			}

			loss[0][0] = cave[0][0];
			dijkstra(0, 0);

			sb.append("Problem " + cnt++ + ": " + loss[N - 1][N - 1] + "\n");

		}

		System.out.println(sb);

	}

	private static void dijkstra(int i, int j) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(i, j, 0));

		while (!pq.isEmpty()) {

			Node curr = pq.poll();

			if (cave[curr.r][curr.c] == -1)
				continue;

			cave[curr.r][curr.c] = -1;

			for (int d = 0; d < 4; d++) {

				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if (check(nr, nc) && cave[nr][nc] != -1 && loss[nr][nc] > loss[curr.r][curr.c] + cave[nr][nc]) {
					loss[nr][nc] = loss[curr.r][curr.c] + cave[nr][nc];
					pq.offer(new Node(nr, nc, loss[nr][nc]));

				}

			}

		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}

package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

	static int N;
	static boolean[][] board;
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {

			N = Integer.parseInt(br.readLine()); // N*N 보드 N개의 퀸
			board = new boolean[N][N];
			cnt = 0;

			nQ(0);

			sb.append("#" + TC + " " + cnt + "\n");
		}

		System.out.println(sb);

	}

	// idx행
	static void nQ(int idx) {

		// 기저 조건
		if (idx == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {

			if (check(idx, i)) { // NQ 가능이면
				board[idx][i] = true; // 그 값을 1로 지정하고
			} else { // 불가능이면 다시 확인
				continue;
			}

			nQ(idx + 1); // 다음으로 넘어가기

			// 원상복구
			board[idx][i] = false;

		}

	}

	// (a,b)에 놓았을 때 NQueen인지 확인
	// 상, 좌상, 우상만 확인
	static boolean check(int a, int b) {

		int[] dr = { -1, -1, -1 };
		int[] dc = { 0, -1, 1 };

		for (int d = 0; d < 3; d++) {

			int nr = a + dr[d];
			int nc = b + dc[d];

			while (nr >= 0 && nr < N && nc >= 0 && nc < N) { // 이 범위에 있으면

				if (board[nr][nc]) {
					return false;

				}

				nr += dr[d];
				nc += dc[d];

			}

		}

		return true;

	}

}
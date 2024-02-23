package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4615_김명화 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());

			int[][] board = new int[N + 1][N + 1];

			// black = 1, white = 2
			// 게임 준비
			board[N / 2][N / 2] = 2;
			board[N / 2 + 1][N / 2] = 1;
			board[N / 2][N / 2 + 1] = 1;
			board[N / 2 + 1][N / 2 + 1] = 2;

			for (int i = 0; i < M; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st2.nextToken());
				int r = Integer.parseInt(st2.nextToken());
				int color = Integer.parseInt(st2.nextToken());

				play(board, r, c, color);
				check(board, r, c, color);

			}

			int sumB = 0;
			int sumW = 0;

			for (int r = 0; r < board.length; r++) {
				for (int c = 0; c < board[r].length; c++) {
					if (board[r][c] == 1) {
						sumB++;
					} else if (board[r][c] == 2) {
						sumW++;
					}
				}
			}

			System.out.printf("#%d %d %d%n", TC, sumB, sumW);

		}

	}

	static void play(int[][] board, int r, int c, int color) {

		if (color == 1) {
			board[r][c] = 1;
		} else {
			board[r][c] = 2;
		}

	}

	static void check(int[][] board, int r, int c, int color) {

		int opponentColor = (color == 1) ? 2 : 1;

		// 8방 탐색
		int[] dr = { 0, 0, -1, 1, -1, -1, 1, 1 };
		int[] dc = { -1, 1, 0, 0, -1, 1, -1, 1 };

		for (int d = 0; d < 8; d++) {
			for (int i = 1; i < board.length - 1; i++) {
				int nr = r + i * dr[d];
				int nc = c + i * dc[d];

				if (nr >= 1 && nr < board.length && nc >= 1 && nc < board.length) {

					int cell = board[nr][nc];

					if (cell == opponentColor) {
						// 상대편 돌과 색이 같으면 계속 진행
					} else if (cell == color) {
						// 같은 색 돌을 만난다면 사이에 있는 돌들 색 변경 후 다음 방향 탐색
						for (int j = 1; j <= i; j++) {
							board[r + j * dr[d]][c + j * dc[d]] = color;
						}
						break;
					} else { // 빈 공간일 때
						break;
					}

				}
			}

		}

	}

}

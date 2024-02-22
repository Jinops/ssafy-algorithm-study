package codingtest;

import java.util.Scanner;

public class SWEA_4615_재미있는오셀로게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int t = 1; t <= tc; t++) {
			int length = sc.nextByte(); // 보드 한 변의 길이
			int[][] map = new int[length + 1][length + 1]; // 0은 사용하지 않음
			map[length / 2][length / 2] = 2;
			map[length / 2 + 1][length / 2] = 1;
			map[length / 2][length / 2 + 1] = 1;
			map[length / 2 + 1][length / 2 + 1] = 2;
			int time = sc.nextInt(); // 돌을 놓는 횟수
			for (int i = 0; i < time; i++) { //
				int c = sc.nextByte(); // x값
				int r = sc.nextByte(); // y값
				int p = sc.nextByte(); // 흑이면 1, 백이면 2
				map[r][c] = p;
				for (int d = 0; d < 8; d++) { // 8방 탐색
					int nr = (r + dr[d]);
					int nc = (c + dc[d]);
					int reverseCount = 0; // 뒤집힐 돌의 수
					while (nr >= 1 && nr <= length && nc >= 1 && nc <= length && map[nr][nc] != p && map[nr][nc] > 0) {
						reverseCount++;
						nr += dr[d];
						nc += dc[d];
					}
					if (nr >= 1 && nr <= length && nc >= 1 && nc <= length && map[nr][nc] > 0) { // 만약 범위 내에 있고, 빈 칸이 아니라면 같은 색 돌을 찾은 경우
						for (int j = 0; j < reverseCount; j++) {
							nr -= dr[d];
							nc -= dc[d];
							map[nr][nc] = p;
						}
					}
				}

			}
			int blackCount = 0;
			for (int r = 1; r <= length; r++) {
				for (int c = 1; c <= length; c++) {
					if (map[r][c] == 1)
						blackCount++;
				}
			}
			sb.append("#" + t + " " + blackCount + " " + (time + 4 - blackCount)).append("\n");
		}
		System.out.print(sb);
	}

}

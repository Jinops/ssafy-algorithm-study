package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10580_김명화 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine()); // 전선의 개수
			int[] x = new int[N];
			int[] y = new int[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if ((x[i] - x[j]) * (y[i] - y[j]) < 0) { // 교차될 때 cnt 증가
						cnt++;
					}
				}

			}

			System.out.printf("#%d %d%n", t, cnt);
		}

	}

}

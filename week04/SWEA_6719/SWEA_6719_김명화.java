package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6719_김명화 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st1.nextToken());
			int K = Integer.parseInt(st1.nextToken());

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int[] lecture = new int[N]; // 프로그래밍 강좌의 수준
			for (int i = 0; i < N; i++) {
				lecture[i] = Integer.parseInt(st2.nextToken());
			}

			Arrays.sort(lecture); // 오름차순 정렬

			double skill = 0;

			for (int i = N-K; i < N; i++) { // 뒤에서부터 K개의 값을 가져왔을 때 최대
				skill = (skill + lecture[i]) / 2;
			}
			
			System.out.printf("#%d %.6f %n", TC, skill);

		}

	}

}

package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class SWEA_1865_김명화 {

	static int N;
	static double[][] worker;
	static boolean[] arr;
	static double max;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int TC = 1; TC <= T; TC++) {

			N = Integer.parseInt(br.readLine());
			worker = new double[N][N];
			arr = new boolean[N];
			max = Integer.MIN_VALUE;

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					worker[r][c] = (Double.parseDouble(st.nextToken())/100);
				}
			}

			distribute(0, 1);
			System.out.printf("#%d %.6f%n", TC, max*100);

		}

	}

	// idx행
	static void distribute(int idx, double sum) {

		// 기저조건
		if (max > sum) {
			return;
		}

		if (idx == N) {
			max = sum;
			return;
		}

		// i열
		for (int i = 0; i < N; i++) {
			if (worker[idx][i]!=0 && !arr[i]) {	
				arr[i] = true;
				distribute(idx + 1, sum * worker[idx][i]);
				arr[i] = false;
			}
			
		}
	}

}
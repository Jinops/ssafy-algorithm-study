package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5986_김명화 {

	static int N;
	static boolean[] isNotPrime;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		generatePrimes();

		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int result = vino(N);
			sb.append("#" + TC + " " + result + "\n");
		}
		System.out.println(sb);

	}

	static int vino(int N) {

		int cnt = 0;
		for (int i = 1; i <= N - 2; i++) {
			for (int j = i; j <= N - 1 - i; j++) {
				int k = N - i - j;
				if (k >= j && !isNotPrime[i] && !isNotPrime[j] && !isNotPrime[k]) {
					cnt++;
				}

			}
		}

		return cnt;

	}

	static void generatePrimes() { // 에라토스테네스의 체

		isNotPrime = new boolean[1000];
		isNotPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(999); i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j <= 999; j += i) {
					isNotPrime[j] = true;
				}

			}

		}

	}

}

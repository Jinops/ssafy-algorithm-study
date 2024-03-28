package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486_퇴사2 {

	static int N;
	static int[] T, P;
	static int max;
	static int[] DP;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		T = new int[N + 2];
		P = new int[N + 2];
		DP = new int[N + 2];
		
		for (int i = 1; i < N + 1; i++) {
			
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N + 2; i++) {
			
			if (max < DP[i]) max = DP[i];
			
			int day = i + T[i];
			if (day < N + 2) {
				DP[day] = Math.max(DP[day], max + P[i]);
			}
		}
		
		System.out.println(max);
	}
}
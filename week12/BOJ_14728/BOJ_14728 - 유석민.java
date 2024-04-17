package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14728_벼락치기_1차원배열 {

	static int N, T;	// 단원 개수, 총 시간
	static int[] K;	// 단원 별 예상 공부 시간
	static int[] S;	// 문제 배점
	static int[] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		K = new int[N + 1];
		S = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			
			st = new StringTokenizer(br.readLine());
			K[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		DP = new int[T + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int k = T; k >= K[i]; k--) {
				DP[k] = Math.max(DP[k], DP[k - K[i]] + S[i]);
			}
		}	// i에 대한 for문
		
		System.out.println(DP[T]);
	}	// main
}
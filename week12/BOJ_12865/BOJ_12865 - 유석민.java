package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한_배낭 {

	static int N;	// 물품의 수
	static int K;	// 최대 무게
	static int[] W;	// 각 물건의 무게
	static int[] V;	// 각 물건의 가치
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[K + 1];
		V = new int[K + 1];
		dp = new int[K + 1];
		
		for (int i = 1; i <= N; i++) {
			
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = K; j - W[i] >= 0; j--) {
				
				dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
			}
		}
		
		System.out.println(dp[K]);
	}
}

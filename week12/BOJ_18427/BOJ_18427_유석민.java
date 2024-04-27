package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18427_함께_블록_쌓기 {

	static int N, M, H;	// 학생 수, 최대 블록 수, 높이
	static List<Integer>[] block;
	static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		DP = new int[N + 1][1001];
		block = new ArrayList[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			
			block[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				block[i].add(Integer.parseInt(st.nextToken()));
		}	// for문
		
		for (int i = 0; i < N + 1; i++)
			DP[i][0] = 1;
		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j <= H; j++) {
				for (Integer num : block[i]) {
					
					if (j >= num) {
						DP[i][j] += DP[i - 1][j - num];
						DP[i][j] %= 10007;
					}
				}
				
				DP[i][j] += DP[i - 1][j];
				DP[i][j] %= 10007;
			}
		}
		
		System.out.println(DP[N][H]);
	}	// main
}
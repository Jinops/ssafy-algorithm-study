import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 단원 개수
		int T = Integer.parseInt(st.nextToken()); // 총 시간

		int[] time = new int[N+1];
		int[] score = new int[N+1];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			time[n] = Integer.parseInt(st.nextToken());
			score[n] = Integer.parseInt(st.nextToken());	
		}
		
		// T 이내의 시간에서 N개 이내의 문제 개수로 얻을 수 있는 최대 배점을 각 칸에 저장
		int[][] dp = new int [N+1][T+1];
		
		for(int t=1; t<=T; t++) { // 시간
			for(int n=1; n<=N; n++) { // 문제 개수
				dp[n][t] = dp[n-1][t];
				// 다른 문제도 더 풀 수 있는 여유가 있다면
				if(t - time[n]>=0) {
					dp[n][t] = Math.max(dp[n-1][t], score[n] + dp[n-1][t-time[n]]);
				}
			}
		}
		System.out.println(dp[N][T]);
//		for(int n=1; n<=N; n++) {
//			System.out.println(Arrays.toString(dp[n]));			
//		}
	}
}
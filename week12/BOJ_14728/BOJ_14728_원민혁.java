import java.util.Scanner;

public class BOJ_14728_벼락치기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int[] dp1 = new int[T+1];
		int[] dp2 = new int[T+1];
		for (int i = 0; i < N; i++) {
			int K = sc.nextInt(); // 문제 공부 시간
			int S = sc.nextInt(); // 문제 배점
			for (int j = 0; j <= T; j++) {
				if (j - K >= 0) {
					dp2[j] = Math.max(dp1[j-K] + S, dp1[j]);
				}
			}
			dp1 = dp2.clone();
		}
		System.out.println(dp1[T]);
	}
}

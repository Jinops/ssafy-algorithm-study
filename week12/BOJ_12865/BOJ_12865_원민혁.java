import java.util.Scanner;

public class BOJ_12865_평범한배낭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] dp1 = new int[K+1];
		int[] dp2 = new int[K+1];
		for (int i = 0; i < N; i++) {
			int W = sc.nextInt();
			int V = sc.nextInt();
			for (int j = 0; j <= K; j++) {
				if (j-W >= 0) {
					dp2[j] = Math.max(dp1[j-W]+V, dp1[j]);
				}
			}
			dp1 = dp2.clone();
		}
		System.out.println(dp1[K]);
	}
}

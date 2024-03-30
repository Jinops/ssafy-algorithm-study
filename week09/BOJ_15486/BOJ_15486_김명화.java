
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15486_김명화 {

	static int N;
	static int[][] schedule;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		schedule = new int[2][N + 1];
		dp = new int[N + 2];

		for (int c = 1; c <= N; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			schedule[0][c] = Integer.parseInt(st.nextToken());
			schedule[1][c] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);

			if (i + schedule[0][i] <= N + 1) {
				dp[i + schedule[0][i]] = Math.max(dp[i + schedule[0][i]], dp[i] + schedule[1][i]);

			}

		}


		System.out.println(Math.max(dp[N], dp[N + 1]));

	}

}

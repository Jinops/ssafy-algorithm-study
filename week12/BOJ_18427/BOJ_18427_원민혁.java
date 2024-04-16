import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18427_함께블록쌓기 {
	static int N, M, H;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 학생별 최대 블록 수
		H = Integer.parseInt(st.nextToken()); // 목표 탑 높이
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		int[][] dp = new int[N + 1][H + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = st.countTokens(); // 학생 별 블록 수
			for (int j = 0; j < size; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		dp[0][0] = 1;
		for (int i = 1; i <= N; i++) { // 학생
			dp[i][0] = 1;
			for (int j = 0; j < list[i].size(); j++) { // 학생이 가진 블록
//				System.out.println(list[i].get(j));
				for (int h = 1; h <= H; h++) { // 전체 높이
					if (h >= list[i].get(j)) {
						dp[i][h] += dp[i - 1][h - list[i].get(j)];
					}
				}
			}
			for (int h = 1; h <= H; h++) { // 학생이 하나도 뽑지 않았을 경우 고려
				dp[i][h] += dp[i - 1][h];
				dp[i][h] %= 10007;
			}
//			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(dp[N][H]);
	}

}

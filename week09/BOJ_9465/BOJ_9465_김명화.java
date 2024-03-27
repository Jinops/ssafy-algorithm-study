import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_김명화 {

	static int N;
	static int[][] sticker;
	static int[][] dp;
//	static int[] dr = { 0, 0, -1, 1 };
//	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			N = Integer.parseInt(br.readLine());
			sticker = new int[2][N + 1];
			dp = new int[2][N + 1];
			
			for (int r = 0; r < 2; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 1; c <= N; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			
			for (int c = 2; c <= N; c++) {
				
				dp[0][c] = Math.max(dp[1][c - 2], dp[1][c - 1]) + sticker[0][c];
				dp[1][c] = Math.max(dp[0][c - 2], dp[0][c - 1]) + sticker[1][c];
				
				
			}
			
			System.out.println(Math.max(dp[0][N], dp[1][N]));
			
		}
		

	}


}

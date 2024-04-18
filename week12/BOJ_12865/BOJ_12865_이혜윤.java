import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] product; 
	static int N, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		product = new int[N+1][2];
		
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			product[n][0] =Integer.parseInt(st.nextToken()); // 무게
			product[n][1] =Integer.parseInt(st.nextToken()); // 가치
		}
		
		// c 이내의 무게에서 N개 이내의 물건으로 낼 수 있는 최대 가치를 각 칸에 저장
		int[][] dp = new int[N+1][K+1];
		
		for(int k=1; k<=K; k++) { // 무게
			for(int i=1; i<=N; i++) { // item
				dp[i][k] = dp[i-1][k];
				if(k - product[i][0] >=0) { // 다른 물건도 담을 수 있는 무게 여유가 있다면
					// dp[i-1][k] : i번째 아이템을 추가했을 때 남은 무게 한도 (k - product[i][0]) 내에서 i-1개의 아이템으로 달성할 수 있는 최대 가치
					dp[i][k]= Math.max(dp[i-1][k], product[i][1] + dp[i-1][k-product[i][0]]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}
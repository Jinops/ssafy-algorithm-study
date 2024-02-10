import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10580_유석민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			
//			전선의 개수
			int N = Integer.parseInt(br.readLine());
			int[][] sun = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
//				i번 index에 해당하는 전선의 좌측 좌표
				sun[i][0] = Integer.parseInt(st.nextToken());
//				i번 index에 해당하는 전선의 우측 좌표
				sun[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for (int r = 0; r < N - 1; r++) {
				for (int i = r + 1; i < N; i++) {
					if ((sun[r][0] - sun[i][0]) * (sun[r][1] - sun[i][1]) < 0) cnt++;
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}

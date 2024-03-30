import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[2][n+2];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 2; j < n+2; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for (int c = 2; c < n+2; c++) { // 스티커 지도 가로
				for (int r = 0; r < 2; r++) { // 스티커 지도 세로
					map[r][c] += Math.max(map[(r+1)%2][c-1], map[(r+1)%2][c-2]);
					if (map[r][c] > max)
						max = map[r][c];
				}
			}
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	}
}
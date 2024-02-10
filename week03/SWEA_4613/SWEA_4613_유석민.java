import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_유석민 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
//			W, B, R을 표시할 이차원 배열 map
			char[][] map = new char[N][M];
//			r번째 index에 해당하는 줄에 있는 W, B, R의 개수를 각각 color[r][0], color[r][1], color[r][2]에 저장
			int[][] color = new int[N][3];
			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < M; c++) {
					map[r][c] = str.charAt(c);
					if (map[r][c] == 'W') color[r][0]++;
					else if (map[r][c] == 'B') color[r][1]++;
					else color[r][2]++;
				}
			}
			
//			color배열의 누적합을 저장할 배열 colorStack
			int[][] colorStack = new int[N][3];
			colorStack[0][0] = color[0][0];
			colorStack[0][1] = color[0][1];
			colorStack[0][2] = color[0][2];
			for (int r = 1; r < N; r++) {
				colorStack[r][0] = colorStack[r - 1][0] + color[r][0];
				colorStack[r][1] = colorStack[r - 1][1] + color[r][1];
				colorStack[r][2] = colorStack[r - 1][2] + color[r][2];
			}
			
			int A = 0, B = 0, C = 0;
			int max = 0;
			for (int r1 = 0; r1 < N - 2; r1++) {
//				A = 0번 index에 해당하는 row부터 r1번 index에 해당하는 row까지 W의 개수
				A = colorStack[r1][0];
				for (int r2 = r1 + 1; r2 < N - 1; r2++) {
//					B = (r1 + 1)번 index에 해당하는 row부터 r2번 index에 해당하는 row까지 B의 개수
					B = colorStack[r2][1] - colorStack[r1][1];
//					C = (r2 + 1)번 index에 해당하는 row부터 (N - 1)번(=마지막) index에 해당하는 row까지 R의 개수 
					C = colorStack[N - 1][2] - colorStack[r2][2];
//					A + B + C의 합이 크면 클수록 칠해야하는 W, B, R의 개수는 줄어든다.
					if (max < A + B + C) max = A + B + C;
				}
			}
			
			int min = N * M - max;
			System.out.println("#" + t + " " + min);
		}
	}
}

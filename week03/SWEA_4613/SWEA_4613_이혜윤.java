package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 러시아국기같은깃발_4613 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static char[][] arr;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new char[N][M];
			int wCnt=0; 
			int bCnt=0;
			int rCnt=0;
			int[] w = new int[N]; // 각 line 별 w 개수 저장
			int[] b = new int[N]; // 각 line 별 b 개수 저장
			int[] r = new int[N]; // 각 line 별 r 개수 저장
			int[] ws = new int[N - 2]; 
			int[] rs = new int[N - 2];
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					arr[n][m] = st.nextToken().charAt(0);
					if(arr[n][m]  != 'W') wCnt++;
					if(arr[n][m]  != 'B') bCnt++;
					if(arr[n][m]  != 'R') rCnt++;
				}
				w[n] = wCnt;
				b[n] = bCnt;
				r[n] = rCnt;
			}
			
			ws[0] = w[0];
			rs[0] = r[N-1];

			for(int i = 1; i < N - 2; i++) {
				// 흰색 몇줄, 빨간 색 몇줄을 미리 저장한 후 그에 따라 파란색을 칠해야하는 수만 사이클마다 탐색
				ws[i] = ws[i - 1] + w[i];
				rs[i] = rs[i - 1] + r[N - 1 - i];
			}
			
			int result = N*M;
			for(int i=0; i<N-2; i++) {
				for(int j=0; j<N-2; j++) {
					int tmp=0; 
					tmp += ws[i];
					tmp += rs[j];
					for(int k = i+1; k<N-j-1; k++) tmp+= b[k];
					result = Math.min(result, tmp);
				}
			}
			System.out.println("#"+t+" "+result);
			
			// 바꾸는게 적은 걸 세려고하지 말고, 유지시킬 수 있는게 많은 걸로 생각을 바꾸자

			// 첫줄은 다 W로
			// 마지막줄은 다 R로

			// W는 n=0 부터 n=N-3 까지 가능
			// B는 n=1 부터 n=N-2 까지 가능
			// R는 n=2 부터 n=N-1 까지 가능
		}
	}
}

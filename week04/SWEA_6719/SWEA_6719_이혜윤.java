package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 성수의프로그래밍강좌시청_6719 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 강좌 총 개수
			int K = Integer.parseInt(st.nextToken()); // 시청할 강좌 개수
			int[] M = new int[N];
			
			st= new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				M[n] = Integer.parseInt(st.nextToken()); // 강좌 수준
			}
			
			Arrays.sort(M);
			double skill =0;
			for(int i= N-K; i<N; i++) {
				skill = (skill + M[i]) / 2;
			}
			System.out.printf("#"+t+" "+"%.6f", skill);
			System.out.println();	
		}
	}
}

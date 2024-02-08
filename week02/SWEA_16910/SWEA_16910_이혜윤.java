package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원안의점_16910 {
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int cnt1=0; // 사분원 내부 점 개수
			for(int x=1; x<=N; x++) {
				for(int y=1; y<=N; y++) {
					if(x*x+y*y<=N*N) cnt1++;
				}
			}
			int cnt2= 1+ N*4; //(0,0) + 축 위의 점
			int res = cnt1*4 + cnt2;
			sb.append("#"+t+" "+res+"\n");
		}
		System.out.println(sb);
	}
}

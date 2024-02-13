package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_김명화 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] flag = new char[N][M];
			
			for(int r=0; r<flag.length; r++) {
				String str = br.readLine();
				for(int c=0; c<flag[r].length; c++) { // 오래된 깃발
					flag[r][c] = str.charAt(c); 
				}
				
			}
			
			int min = Integer.MAX_VALUE;
			
			for(int a=1; a<N; a++) {
				for(int b=1; b<N; b++) {
					for(int c=1; c<N; c++) {
						if(a + b + c == N) {
							
							int cnt = 0;
							
							for(int i=0; i<a; i++) {
								for(int j=0; j<flag[i].length; j++) {
									if(flag[i][j]!='W') {
										cnt++;
									}
								}
							}
							
							for(int i=a; i<a+b; i++) {
								for(int j=0; j<flag[i].length; j++) {
									if(flag[i][j]!='B') {
										cnt++;
									}
								}
							}
							
							for(int i=b; i<b+c; i++) {
								for(int j=0; j<flag[i].length; j++) {
									if(flag[i][j]!='R') {
										cnt++;
									}
								}
							}
							
							if(min>cnt) min = cnt;
							
						}

					}
				}
			}
			
			System.out.printf("#%d %d%n", TC, min);
			
		}
		
	}

}

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7087_이혜윤 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			// 각 타이틀의 첫 알파벳 별 개수 저장할 배열
			// 0번째 인덱스 값 = A로 시작하는 title 개수
			int[] titleAlpha = new int['Z'-'A'+1];
			int N =Integer.parseInt(br.readLine());
			
			// 주어진 제목의 첫 글자로 카운트
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				titleAlpha[str.charAt(0)-'A']++; 
			}
			
			// A부터 연속적으로 이어가보기. 
			// 개수 자체는 중요치 X 있냐 없냐가 중요.
			// 있으면 이어가고 그 과정중에 하나라도 없으면 break
			int cnt=0;
			for(int i=0; i<titleAlpha.length; i++) {
				if(titleAlpha[i]>0) {
					cnt++;
				} else {
					break;
				}
			}
			
			sb.append("#"+t+" "+cnt+"\n");
		}
		
		System.out.println(sb);
	}
}

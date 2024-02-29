package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한빈이와spotmarket_9229 {
	
	static int N, M;
	static int maxSum;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		int T =Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			maxSum=0;
			
			st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			getMax(0, 0, 0);
			if(maxSum==0) maxSum=-1;
			sb.append("#"+t+" "+maxSum+"\n");
		
		}
		System.out.println(sb);
		

	}
	
	static void getMax(int arrIdx, int selectIdx, int kg) {
		if(kg>M) return;
		
		if(selectIdx==2) {
			maxSum = Math.max(maxSum, kg);
			return; 
		}
		if(arrIdx==N) return;
		
		// 추가 안하는 경우
		getMax(arrIdx+1, selectIdx, kg);
		
		// 추가하는 경우
		kg += arr[arrIdx];
		getMax(arrIdx+1, selectIdx+1, kg);
		
	}
}
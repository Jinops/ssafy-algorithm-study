import java.util.Scanner;

public class SWEA_16910_배준영 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int cnt = 0;
			
			for(int x=1; x<=N; x++) {
				for(int y=1; y<=N; y++) {
					
					if( x*x + y*y <= N*N)
						cnt++;
					
				}
			}
			cnt = cnt*4;
			cnt+=N*4 + 1;
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
		
		
	}
}
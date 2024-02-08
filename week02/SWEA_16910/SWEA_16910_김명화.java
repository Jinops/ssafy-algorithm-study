import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_16910_김명화 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int point = 0;
			
			for(int r=-N; r<=N; r++) {
				for(int c=-N; c<=N; c++) {
					if(r * r + c * c <= N * N) {
						point++;
					}
				}
			}
			
			System.out.printf("#%d %d%n", i + 1, point);
		}
		
	}

}

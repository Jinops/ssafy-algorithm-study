import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_16910 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < T + 1; i++) {
			
			int cnt = 0;
			int r = Integer.parseInt(br.readLine());
			for (int x = 0; x <= r; x++) {
				for (int y = 0; y * y <= r * r - x * x; y++) {
					cnt++;
				}
			}
			System.out.println("#" + i + " " + ((4 * cnt) - 2 * (2 * r + 1) - 1));
		}
	}
}

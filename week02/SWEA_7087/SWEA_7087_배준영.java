import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_7087_배준영 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = Integer.parseInt(br.readLine());

			char[] titles = new char[N];

			for (int i = 0; i < N; i++) {
				titles[i] = br.readLine().charAt(0);
			}

			Arrays.sort(titles);

			int checkNum = 65;
			int count = 0;
			for(int i=0; i<titles.length; i++) {
				
				if((int) titles[i] == checkNum) {
					count++;
					checkNum++;
				} 
			}
			
			
			System.out.printf("#%d %d \n", test_case, count);
		}
		br.close();
	}
}
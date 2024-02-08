import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWEA_7087 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i < T + 11; i++) {
			
			// 제목의 개수를 입력
			int N = Integer.parseInt(br.readLine());
			// A ~ Z까지 저장하기 위해 26개짜리 리스트 선언
			Boolean[] checkList = new Boolean[26];
			for (int j = 0; j < 26; j++) {
				checkList[j] = false;
			}

			for (int j = 0; j < N; j++) {
				// A부터 0번 index에 대응시키고 해당 index의 값을 true로 바꿈
				checkList[br.readLine().charAt(0) - 'A'] = true;
			}
			
			int cnt = 0;
			// 연속하는 true의 개수를 카운트
			while (true) {
				if (checkList[cnt]) {
					cnt++;
				} else {
					break;
				}
			}
			
			System.out.println("#" + i + " " + cnt);
		}
	}
}

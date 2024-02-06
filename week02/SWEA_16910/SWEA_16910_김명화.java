import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_16910_김명화 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			String[] strArr = new String[N];
			
			for(int j=0; j<strArr.length; j++) { // 테스트케이스를 String 배열로 받기
				strArr[j] = br.readLine();
			}
			
			int[] alphabet = new int[26]; // strArr 배열의 각 성분들의 알파벳 첫 글자에 대한 cnt 배열 만들기
			for(int j=0; j<strArr.length; j++) { 
				alphabet[strArr[j].charAt(0)-'A']++;
			}
			
			int[] cnt = new int[alphabet.length]; // 누적cnt 배열
			cnt[0] = alphabet[0];
			for(int j=1; j<alphabet.length; j++) {
				cnt[j] += cnt[j-1];
			}
			
			int output = 0;
			for(int j=0; j<alphabet.length; j++) {
				if(alphabet[j]==0) {
					output = j;
					break;
				} else {
					output++;
				}
			}
			System.out.printf("#%d %d%n", i+1, output);
		}

	}

	
}

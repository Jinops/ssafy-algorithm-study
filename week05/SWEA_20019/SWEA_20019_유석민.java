import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_20019_유석민 {
	
	static boolean ansLeft;
	static boolean ansRight;
	static boolean ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			String str = br.readLine();
			if (checkPalin(str)) sb.append("#" + t + " YES\n");
			else sb.append("#" + t + " NO\n");
		}
		System.out.println(sb);
	}
	
	// 회문인지 판별하는 메소드
	static boolean checkPalin(String str) {
		
		boolean ans = true;
		boolean ansLeft = true;
		boolean ansRight = true;
		
		int len = str.length();
		for (int i = 0; i < str.length() / 2; i++) { 
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) ans = false;
		}
		
		// 왼쪽 문자열 회문검사
		for (int i = 0; i < (str.length() / 2) / 2; i++) {
			if (str.charAt(i) != str.charAt((str.length() / 2) - 1 - i)) ansLeft = false; 
		}
		
		// 오른쪽 문자열 회문검사
		for (int i = 0; i < (str.length() / 2) / 2; i++) {
			if (str.charAt((str.length() / 2) + 1 + i) != str.charAt(str.length() - 1 - i)) ansRight = false;
		}
		
		if (ans && ansLeft && ansRight) return true;
		else return false;
	}
}
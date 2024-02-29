package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_20019_회문의회문 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String str = br.readLine();
			String result = "";
			if (isPalindrome(str)) {
				result = "YES";
			} else {
				result = "NO";
			}
			sb.append("#"+t+" "+result).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isPalindrome(String str) {
		int length = str.length();
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - 1 - i)) {
				return false;
			}
			if (str.charAt(i) != str.charAt(length / 2 - 1 - i)) {
				return false;
			}
			if (str.charAt(length - (length / 2) + i) != str.charAt(length - 1 - i)) { // 홀수일 경우를 고려해서 길이에서 길이 / 2만큼 뺀다.
				return false;
			}
		}
		return true;
	}
}

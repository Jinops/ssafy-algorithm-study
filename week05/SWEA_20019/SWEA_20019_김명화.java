package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_20019_김명화 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			String vocab = br.readLine();
			int n = vocab.length();

			boolean isPalindrome = checkP(vocab);
			
			if(isPalindrome)
				isPalindrome = checkP(vocab.substring(0, (n - 1) / 2));

			if(isPalindrome)
				isPalindrome = checkP(vocab.substring(n / 2 + 1));

			String output = isPalindrome? "YES" : "NO";
			
			sb.append("#").append(i).append(" ").append(output).append("\n");
		}
		System.out.println(sb);
	}

	static Boolean checkP(String str) {

		for (int i = 0; i < str.length() / 2; i++) {
			
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}

		return true;
	}

}

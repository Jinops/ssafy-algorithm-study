package algorithm_prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_7087_문제제목붙이기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int num = Integer.parseInt(br.readLine());
			char[] titleFirstWord = new char[num];
			for (int i = 0; i < num; i++) {
				String title = br.readLine();
				titleFirstWord[i] = title.charAt(0);
			}
			Arrays.sort(titleFirstWord);
			char check = 'A';
			int count = 0;
			for (int i = 0; i < num; i++) {
				if (titleFirstWord[i] == check) {
					check++;
					count++;
				}
				else if (titleFirstWord[i] > check)
					break;
			}
			sb.append("#"+t+" "+count+"\n");
		}
		System.out.println(sb);
	}
}

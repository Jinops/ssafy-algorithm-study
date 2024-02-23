package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_3752_가능한시험점수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] grades = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			for (int i = 0; i < N; i++) {
				int grade = Integer.parseInt(st.nextToken());
				max += grade;
				grades[i] = grade;
			}
			boolean[] count = new boolean[max + 1];
			count[0] = true; // 0점은 언제나 가능
			int curMax = 0;
			for (int g : grades) {
				for (int i = curMax; i >= 0; i--) {
					if (count[i])
						count[i+g] = true;
				}
				curMax += g;
			}
			
			int c = 0;
			for (int i = 0; i < count.length; i++) {
				if (count[i])
					c++;
			}
			sb.append("#" + t + " " + c + "\n");
		}
		System.out.println(sb);
	}
}

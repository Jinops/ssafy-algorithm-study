package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4371_김명화 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int all = Integer.parseInt(br.readLine());
			int[] num = new int[N - 1];
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(br.readLine()) - all; // 첫 번째 즐거운 날을 제외하고 테스트 케이스-all을 배열로 만들기
			}

			int boat = 0;
			for (int i = 1; i < num.length; i++) {
				boolean isMin = true;
				for (int j = 0; j < i; j++) {
					if (num[i] % num[j] == 0) {
						isMin = false;
						break;
					}
				}

				if (isMin) {
					boat++;
				}
				
			}

			sb.append("#" + TC + " ").append(boat+1).append("\n");

		}
		System.out.println(sb);

	}

}


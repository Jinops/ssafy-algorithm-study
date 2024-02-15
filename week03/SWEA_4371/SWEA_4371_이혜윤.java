package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 항구에들어오는배_4371 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];

			ArrayList<Integer> list = new ArrayList<>(); // 주기를 저장할 리스트

			for (int n = 0; n < N; n++) {
				num[n] = Integer.parseInt(br.readLine());
			}

			for (int i = 1; i < N; i++) {
				int tmp = num[i] - num[0]; // 현재 검사대상 간격
				int flag = 0;
				for (int j = 0; j < list.size(); j++) { // j = 간격 후보들
					if (tmp % list.get(j) == 0) {
						flag = 1; // 재재등장한 배라고 표시
						break;
					}
				} // 모든 간격 후보들에 대한 검사가 끝났는데도 불구하고
				if (flag == 0) { // 1일차 이후로 처음 나타난 배라면
					list.add(tmp); // 해당 간격을 새로운 간격으로서 저장
				}
			}
			// 간격의 종류 개수 = 배의 종류 개수
			sb.append("#" + t + " " + list.size() + "\n");
		}
		System.out.println(sb);
	}

}

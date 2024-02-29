package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] snacks = new int[N];
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(snacks);
			int maxWeight = -1;
			for (int i = N - 1; i >= 1; i--) {
				for (int j = i - 1; j >= 0; j--) {
					int weight = snacks[i] + snacks[j];
					if (maxWeight < weight && weight <= M) {
						maxWeight = weight;
					} else if (weight <= maxWeight)
						break;
				}
			}
			sb.append("#" + t + " " + maxWeight).append("\n");
		}
		System.out.print(sb);
	}
}

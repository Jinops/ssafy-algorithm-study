package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1865_동철이의일분배 {
	static double[][] arr;
	static double maxPossibility;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new double[N][N];
			check = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Double.parseDouble(st.nextToken())/100.0;
				}
			}
			
			maxPossibility = 0;
			calPos(0, 1.0);
			String max = String.format("%.6f", maxPossibility*100);
			sb.append("#"+t+" "+max).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void calPos(int worker, double possibility) {
		if (worker >= arr.length) {
			maxPossibility = possibility;
			return;
		}
		for(int i = 0; i < arr[worker].length; i++) {
			if (!check[i] && possibility*arr[worker][i] > maxPossibility) {
				check[i] = true;
				calPos(worker+1, possibility*arr[worker][i]);
				check[i] = false;
			}
		}
	}
}

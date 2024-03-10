package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {
	static int day;
	static int month;
	static int quarter;
	static int year;
	static int[] yearPlan;
	static int totalExpense;
	static int[] monthlyExpense;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			quarter = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			yearPlan = new int[12];
			monthlyExpense = new int[14];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				yearPlan[i] = Integer.parseInt(st.nextToken());
				monthlyExpense[i] = yearPlan[i] * day;
				totalExpense += monthlyExpense[i];
			}
			calExpense();
			sb.append("#" + t + " " + totalExpense).append("\n");
		}
		System.out.print(sb);
	}

	private static void calExpense() {
		int expense = 0;
		for (int i = 0; i < 12; i++) {
			if (monthlyExpense[i] > month)
				monthlyExpense[i] = month;
			expense += monthlyExpense[i];
		}
		if (expense < totalExpense)
			totalExpense = expense;

		quarterExpense(0, 0);

		if (totalExpense > year) {
			totalExpense = year;
		}
	}

	private static void quarterExpense(int idx, int currentExpense) {
		if (idx >= 12) {
			if (currentExpense < totalExpense) {
				totalExpense = currentExpense;
			}
			return;
		}
		if (currentExpense > totalExpense)
			return;
		if (monthlyExpense[idx] + monthlyExpense[idx + 1] + monthlyExpense[idx + 2] > quarter) {
			quarterExpense(idx + 3, currentExpense + quarter);
		}
		quarterExpense(idx + 1, currentExpense + monthlyExpense[idx]);
	}
}

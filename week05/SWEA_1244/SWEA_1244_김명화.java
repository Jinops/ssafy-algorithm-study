package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1244_김명화 {

	static int[] nums;
	static int n;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			n = Integer.parseInt(st.nextToken());
			nums = new int[str.length()];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < nums.length; i++) { // 입력 배열
				nums[i] = str.charAt(i) - '0';

			}

			if (n > nums.length)
				n = nums.length;

			trial(0);

			System.out.printf("#%d %d%n", TC, max);
		}

	}

	static void trial(int idx) {

		if (idx == n) { // n번 시행

			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i] * Math.pow(10, nums.length - 1 - i);
			}

			if (max < sum)
				max = sum;
			return;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				swap(i, j);
				trial(idx + 1);
				swap(i, j); // 원상복구

			}

		}

	}

	static void swap(int a, int b) {

		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

}

package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_5986_새샘이와세소수 {
	static Boolean[] nums = new Boolean[1000];
	static int[] canPrime = new int[1000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		nums[0] = false; nums[1] = false;
		findPrime();
		primeConsist();
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#" + t + " " + canPrime[N]).append("\n");
		}
		System.out.print(sb);
	}

	private static void findPrime() { // 999까지 소수 찾기
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] == null)
				nums[i] = true;
			else
				continue;
			for (int j = 2; i * j < nums.length; j++) {
				nums[i * j] = false;
			}
		}
	}

	private static void primeConsist() {
		for (int i = 2; i < canPrime.length; i++) {
			if (!nums[i])
				continue;
			for (int j = i; i + j < canPrime.length; j++) {
				if (!nums[j])
					continue;
				for (int k = j; i + j + k < canPrime.length; k++) {
					if (nums[k])
						canPrime[i+j+k]++;
					else
						continue;
				}
			}
		}
	}
}

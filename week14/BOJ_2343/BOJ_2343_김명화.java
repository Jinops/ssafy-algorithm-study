import java.io.*;
import java.util.*;

public class BOJ_2343_김명화 {

	static int n, m;
	static int[] lesson;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lesson = new int[n];

		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			right += lesson[i];
			left = Math.max(left, lesson[i]);
		}

		while (left <= right) {
			int mid = (left + right) / 2;

			int count = getCount(mid);

			if (count > m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(left);
	}

	private static int getCount(int mid) {
		int sum = 0;
		int count = 1;
		for (int i = 0; i < n; i++) {
			if (sum + lesson[i] > mid) {
				sum = 0;
				count++;
			}
			sum += lesson[i];
		}

		return count;
	}
}
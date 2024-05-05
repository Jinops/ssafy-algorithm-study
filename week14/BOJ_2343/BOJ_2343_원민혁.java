import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343_기타레슨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // number of lessons
		int M = Integer.parseInt(st.nextToken()); // number of CD
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		int start = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			if (start < arr[i])
				start = arr[i];
		}
		
		while (start <= sum) {
			int mid = (start + sum) / 2;
			int cnt = 0;
			int tmp = 0;
			for (int i = 0; i < N; i++) {
				if (tmp + arr[i] > mid) {
					cnt++;
					tmp = 0;
				}
				tmp += arr[i];
			}
			if (sum > 0)
				cnt++;
			if (cnt > M)
				start = mid + 1;
			else
				sum = mid - 1;
		}
		System.out.println(start);
		
	}	
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1244_유석민 {

	static int N;	// 교환 횟수
	static int max = 0;
	static int[] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();	// 교환 전 상금, 문자열로 입력받은 후
			N = Integer.parseInt(st.nextToken());
			arr = new int[str.length()];

			for (int i = 0; i < arr.length; i++) arr[i] = str.charAt(i) - '0';	// arr배열에 순서대로 저장

			if (arr.length < N) N = arr.length;	// 문자열의 길이가 교환 횟수보다 작다면 교환횟수는 문자열의 길이 만큼만 하면 된다.

			search(0, 0);

			System.out.println("#" + t + " " + max);
			max = 0;
		}
	}

	private static void search(int start, int cnt) {
		
		if (cnt == N) {	// 최대 횟수만큼 교환을 완료했으면
			int result = 0;
			for (int i = 0; i < arr.length; i++) result += power(i) * arr[arr.length - 1 - i];

			max = Math.max(result, max);
			return;	// max변수에 최댓값을 저장하고 메소드 종료
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				
				swap(i, j);
				search(i, cnt + 1);
				swap(i, j);
			}
		}
	}

	private static int power(int n) {
		
		int num = 1;
		for (int i = 0; i < n; i++) num *= 10;
		return num;
	}
	
	private static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
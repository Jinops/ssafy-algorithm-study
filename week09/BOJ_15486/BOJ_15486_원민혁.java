import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 시작하는 날이 1일
public class BOJ_15486 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] calendar = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			calendar[i][0] = i;
			calendar[i][1] = Integer.parseInt(st.nextToken()); // 상담 소요 시간
			calendar[i][2] = Integer.parseInt(st.nextToken()); // 얻는 수익
		}

		Arrays.sort(calendar, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[0] + o1[1]) - (o2[0] + o2[1]); // 어차피 시작날이 빠른 순서대로 정렬되어 있음
			}

		});

		int[] max = new int[n + 2];
		int idx = 1;
		for (int i = 1; i < n + 2; i++) { // max에서 움직임
			max[i] = max[i-1];
			for (; idx <= n; idx++) {
				int finDay = calendar[idx][0] + calendar[idx][1];
				if (i == finDay) {
					max[finDay] = Math.max(max[finDay], max[calendar[idx][0]] + calendar[idx][2]);
				}
				else break;
			}
		}
		System.out.println(max[n+1]);
	}
}
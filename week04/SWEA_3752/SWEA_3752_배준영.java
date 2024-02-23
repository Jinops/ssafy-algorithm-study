import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_3752_배준영 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();

			int[] points = new int[N + 1];
			points[0] = 0;
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				points[i] = sc.nextInt();
				sum += points[i];
			}

			boolean[] check = new boolean[sum + 1];

			List<Integer> result = new ArrayList<>();
			result.add(0);

			for (int i = 1; i <= N; i++) {
				int tmp = result.size();
				for (int j = 0; j < tmp; j++) {
					if (!check[points[i] + result.get(j)]) {
						check[points[i] + result.get(j)] = true;
						result.add(points[i] + result.get(j));
					}
				}

			}

			//

			System.out.printf("#%d %d\n", tc, result.size());
		}

	}

}
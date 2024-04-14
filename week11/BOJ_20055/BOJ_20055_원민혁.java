import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 한쪽 면의 개수
		int K = Integer.parseInt(st.nextToken()); // 내구도가 0인 최대 개수

		int[] belt = new int[2 * N];
		boolean[] robot = new boolean[2 * N];
		int lPointer = 0; // 컨베이어 벨트 짐 실는 곳
		int rPointer = N - 1; // 컨베이어 벨트 짐 내리는 곳
		int cnt = 0; // 내구도 0인 위치의 개수
		int stage = 0; // 진행 중인 단계
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		while (cnt < K) {
			cnt = 0; // 내구도 0 개수 초기화
			robot[rPointer] = false; // 마지막에 위치한 로봇은 하차
			lPointer = (lPointer - 1 + 2 * N) % (2 * N);
			rPointer = (lPointer + N - 1) % (2 * N);
			robot[rPointer] = false;

			for (int i = 1; i < N; i++) {
				int idx = (rPointer - i + (2 * N)) % (2 * N);
				int nIdx = (idx + 1) % (2 * N);
				if (robot[idx] && !robot[nIdx] && belt[nIdx] > 0) {
					robot[idx] = false;
					robot[nIdx] = true;
					belt[nIdx]--;
				}
			}
			robot[rPointer] = false;
			if (!robot[lPointer] && belt[lPointer] > 0) {
				robot[lPointer] = true;
				belt[lPointer]--;
			}
			stage++;

			for (int i = 0; i < 2 * N; i++) {
				if (belt[i] <= 0)
					cnt++;
			}
		}
		System.out.println(stage);

	}
}

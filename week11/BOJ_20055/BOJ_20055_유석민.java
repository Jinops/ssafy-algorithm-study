package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어_벨트_위의_로봇 {

	static int N, K;
	static int[] A;
	static boolean[] robot;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[2 * N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A.length; i++)
			A[i] = Integer.parseInt(st.nextToken());
		
		ans = Rotate(0);
		System.out.println(ans);
		
	}	// main
	
	private static int Rotate(int count) {
		
		while (countZero()) {
			
			// 벨트를 한 칸 만큼 회전시킴
			int tmp = A[A.length - 1];
			for (int i = A.length - 1; i > 0; i--)
				A[i] = A[i - 1];
			A[0] =tmp;
			
			// 벨트 위의 로봇도 회전시킴
			for (int i = robot.length - 1; i > 0; i--)
				robot[i] = robot[i - 1];
			robot[0] = false;
			robot[N - 1] = false;	// 내리는 위치에 도달한 로봇은 내림

			for (int i = N - 1; i > 0; i--) {
				
				// (i - 1)번째에 로봇이 있고 i번째 벨트의 내구도가 1 이상이라면
				// 로봇을 한 칸 옮기고 (i - 1)번째 벨트는 비게 되니 false처리해주며 i번째 벨트의 내구도를 1만큼 감소시킨다.
				if (robot[i - 1] && !robot[i] && A[i] >= 1) {
					robot[i] = true;
					robot[i - 1] = false;
					A[i]--;
				}
			}
			
			// 첫 번째 자리의 벨트의 내구도가 1 이상이면 로봇을 올리고 내구도를 1만큼 감소시킨다.
			if (A[0] > 0) {
				robot[0] = true;
				A[0]--;
			}
			
			count++;
		}
		
		return count;
	}	// Rotate

	private static boolean countZero() {
		
		int cnt = 0;
		
		for (int i = 0; i < 2 * N; i++) {
			
			if (A[i] == 0) cnt++;
			
			if (cnt >= K) return false;
		}
		
		return true;
	}	// countZero
}
package week11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20055_김명화 {

	static int N;
	static int K;
	static int[] belt;
	static int[] robot;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2 * N];
		robot = new int[N]; // 로봇의 위치 저장
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < belt.length; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		int t = 1; // 단계
		while (true) {

			// 벨트 + 로봇 회전
			int tmp1 = belt[belt.length - 1];
			for (int i = belt.length - 1; i >= 1; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = tmp1;

			for (int i = robot.length - 1; i >= 1; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = 0;
			robot[robot.length-1] = 0; //내리기

			// 이동하려는 칸에 로봇이 없고 그 칸의 내구도가 1 이상 남아 있으면 로봇 추가 이동
			for (int i = robot.length - 2; i >= 0; i--) {
				if (robot[i]==1 && robot[i + 1] == 0 && belt[i + 1] >= 1) {
					robot[i + 1] = 1;
					robot[i] = 0;
					belt[i + 1]--; // 내구도 감소
				}


			}
			
			if (belt[0] > 0) {
				robot[0] = 1;
				belt[0]--;
			}

			int cnt = 0;
			for (int i = 0; i < belt.length; i++) {
				if (belt[i] == 0)
					cnt++;
			}

			if (cnt >= K)
				break;
			t++;

		}

		System.out.println(t);

	}

}
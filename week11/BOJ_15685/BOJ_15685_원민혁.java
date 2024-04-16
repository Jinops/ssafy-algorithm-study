import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤커브 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			Deque<Integer> dq = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[y][x] = true;
			int d = Integer.parseInt(st.nextToken()); // direction
			int g = Integer.parseInt(st.nextToken()); // 세대 0부터
			dq.offerLast(d);
			x += dx[d];
			y += dy[d];
			map[y][x] = true; // 무조건 0세댄 있으니까
			while (g > 0) { // 한 세대 반복
				g--;
				int size = dq.size();
				Deque<Integer> tdq = new ArrayDeque<>();
				for (int j = 0; j < size; j++) {
					int direction = dq.pollFirst();
					int tmp = (direction + 1) % 4;
					x += dx[tmp];
					y += dy[tmp];
					if (0 <= x && x <= 100 && 0 <= y && y <= 100) {
						map[y][x] = true;
						tdq.offerFirst(tmp);
						tdq.offerLast(direction);
					} else {
						g = -1; // 끝냄
						break;
					}
				}
				dq = tdq;
			} // while
		} // for
		int cnt = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (map[r][c] && map[r + 1][c] && map[r + 1][c + 1] && map[r][c + 1])
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}

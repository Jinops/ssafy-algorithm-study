package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 드래곤커브 {

	static boolean[][] map = new boolean[101][101];
	static int[] dc = { 1, 0, -1, 0 };
	static int[] dr = { 0, -1, 0, 1 };
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 시작 방향
			int g = Integer.parseInt(st.nextToken()); // 세대

			dragonCurve(c, r, d, g);
		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void dragonCurve(int c, int r, int d, int g) {
		List<Integer> dirList = new ArrayList<>();
		dirList.add(d);
		
		for(int i=1; i<=g; i++) { // 만들어야 하는 세대 만큼
			for(int j=dirList.size()-1; j>=0; j--) { // 이전 세대 개수만큼
				int cur = dirList.get(j);
				dirList.add((cur+1)%4);
			}
		}
		
		map[r][c] = true;
		for(int dir : dirList) {
			r+= dr[dir];
			c+= dc[dir];
			map[r][c] = true;
		}
	}
	
	

}

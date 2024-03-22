package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어2 {

	static int R;
	static int C;
	static int[][] map;
	static int[][] distMap;
	static boolean[][] visit;
	static Queue<int[]> shark = new LinkedList<int[]>();
	static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};	// 상, 하, 좌, 우, 좌상, 좌하, 우상, 우하
	static int[] dc = {0, 0, -1, 1, -1, -1, 1, 1};	// 상, 하, 좌, 우, 좌상, 좌하, 우상, 우하
	static int minDist = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		distMap = new int[R][C];
		
		for (int r = 0; r < R; r++) {
			
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				
				map[r][c] = Integer.parseInt(st.nextToken());
				distMap[r][c] = Integer.MAX_VALUE;
				
				if (map[r][c] == 1) {
					shark.add(new int[] {r, c});
					distMap[r][c] = 0;	// 상어가 위치한 자리는 0
				}
			}
		}
		
		while (!shark.isEmpty()) {
			
			int[] now = shark.poll();
			
			visit = new boolean[R][C];	// 상어가 바뀔 때마다 새롭게 방문처리 하기 위해
			BFS(now[0], now[1]);
		}		
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (minDist < distMap[r][c]) minDist = distMap[r][c];
			}
		}
		System.out.println(minDist);
		
	}	// main
	
	static void BFS(int r, int c) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {r, c});
		
		while (!queue.isEmpty()) {
			
			int[] now = queue.poll();
			int rNow = now[0];
			int cNow = now[1];
			
			for (int i = 0; i < 8; i++) {
				
				int rNext = rNow + dr[i];
				int cNext = cNow + dc[i];
				if (rNext >= 0 && rNext < R && cNext >= 0 && cNext < C && !visit[rNext][cNext] && map[rNext][cNext] == 0) {	// (범위를 벗어나지 않고) && (방문하지 않은) && (빈 칸이라면)
					
					visit[rNext][cNext] = true;	// 방문처리
					queue.add(new int[] {rNext, cNext});
					distMap[rNext][cNext] = Math.min(distMap[rNext][cNext], distMap[rNow][cNow] + 1);	// 안전거리는 여러 마리 상어를 기준으로 제일 작은 값
				}
			}
		}	// while문
	}	// BFS 메소드
}
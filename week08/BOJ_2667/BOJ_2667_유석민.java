package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단지번호붙이기1 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int K;
	static int number;
	static Queue<int[]> queue;
	static Queue<Integer> numOf;
	static int[] numOfzip;
	static int[] dr = {-1, 1, 0, 0};	// 상, 하, 좌, 우
	static int[] dc = {0, 0, -1, 1};	// 상, 하, 좌, 우
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		numOf = new LinkedList<>();
		
//		System.out.println("맵 입력 전");
		
		for (int r = 0; r < N; r++) {
			
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
//		for (int r = 0; r < N; r++) {
//			for (int c = 0; c < N; c++) {
//				System.out.println(map[r][c]);
//			}
//			System.out.println();
//		}
//		System.out.println("number 바로 위");
		number = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				if (map[r][c] == 1 && !visit[r][c]) {
					visit[r][c] = true;
					number++;
					BFS(r, c, number);
				}
			}
		}	// r에 대한 for문
		
		numOfzip = new int[numOf.size()];
		for (int i = 0; i < numOfzip.length; i++) {
			numOfzip[i] = numOf.poll();
		}
		Arrays.sort(numOfzip);
		
		System.out.println(number);
		for (int i = 0; i < numOfzip.length; i++) {
			System.out.println(numOfzip[i]);
		}
		
	}	// main 메소드
	
	static void BFS(int r, int c, int Num) {
		
		queue = new LinkedList<>();
		queue.add(new int[] {r, c});
		
		int count = 1;
		
		while (!queue.isEmpty()) {
			
			int[] now = queue.poll();
			int rNow = now[0];
			int cNow = now[1];
			
			for (int i = 0; i < 4; i++) {
				
				int rNext = rNow + dr[i];
				int cNext = cNow + dc[i];
				if (rNext >= 0 && rNext < N && cNext >= 0 && cNext < N && map[rNext][cNext] == 1 && !visit[rNext][cNext]) {
					
					visit[rNext][cNext] = true;
					map[rNext][cNext] = Num;
					queue.add(new int[] {rNext, cNext});
					count++;
				}
			}
		}
		
		numOf.add(count);
	}	// BFS 메소드
}

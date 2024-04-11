package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685_드래곤_커브 {

	static int N;
	static int x, y;
	static int d, g;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean[][] map = new boolean[101][101];
	static List<Integer> dgn;
	static int ans = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			dragon(x, y, d, g);
		}
		
		for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
            	
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) 
                   ans++;
            }
        }
		
		System.out.println(ans);
	}	// main

	private static void dragon(int X, int Y, int D, int G) {
		
		dgn = new ArrayList<Integer>();
		dgn.add(d);
		
		for (int i = 1; i <= g; i++) {
			for (int j = dgn.size() - 1; j >= 0; j--) {
				
				dgn.add((dgn.get(j) + 1) % 4);
			}
		}	// i에 대한 for문
		
		map[Y][X] = true;
		for (Integer dir : dgn) {
			X += dx[dir];
			Y += dy[dir];
			map[Y][X] = true;
		}
	}	// dragon
}

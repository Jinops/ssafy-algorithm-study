import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_김명화 {

	static int N;
	static int[][] apt;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		apt = new int[N][N];
		visited = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				apt[r][c] = str.charAt(c) - '0';
			}
		}
		int n = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(apt[r][c]==1 && !visited[r][c]) {
					list.add(bfs(r,c,++n));
				}
			}
		}
		
		Collections.sort(list); // 오름차순 정렬
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)+"\n");
		}
		
		System.out.println(n);
		System.out.println(sb);

	}

	public static int bfs(int r, int c, int n) {
		
		int cnt = 0;
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r,c));
		visited[r][c] = true;
		cnt++;
		
		while(!q.isEmpty()) {
			
			Point currP = q.poll();
			int currR = currP.x;
			int currC = currP.y;
			
			for(int d=0; d<4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && apt[nr][nc]==1) {
					
					q.offer(new Point(nr,nc));
					visited[nr][nc] = true;
					cnt++;
					
				}
				
				
			}
			
			
			
		}
		
		return cnt;
		
	}

}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수_4963 {
	
	static int w, h;
	static int arr[][];
	static boolean visited[][];
	static int dc[] = {0,0,-1,1,-1,1, -1, 1};
	static int dr[] = {-1, 1, 0,0,1,1,-1,-1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str =" ";
		while( !(str = br.readLine()).equals("0 0") ) {
			st = new StringTokenizer(str);
			
			w= Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			arr = new int[h][w];
			visited= new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visited[i][j] && arr[i][j] ==1) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}


	private static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int i=0; i<8; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(isPossible(nr, nc) && !visited[nr][nc] && arr[nr][nc]==1) {
				dfs(nr, nc);
			}
		}
	}
	
	static boolean isPossible(int r, int c) {
		if(r<0 || c<0 || r>=h || c>=w) return false;
		return true;
	}
}

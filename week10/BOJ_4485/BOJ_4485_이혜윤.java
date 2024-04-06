package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Loc implements Comparable<Loc>{
	int r;
	int c;
	int lost;
	
	public Loc(int r, int c, int lost) {
		this.r = r;
		this.c = c;
		this.lost = lost;
	}

	@Override
	public int compareTo(Loc l) {
		return Integer.compare(this.lost , l.lost);
	}
}

// 다익스트라는 단순히 방문여부가 아니라 비용을 따져서 nr, nc 큐에 넣는 형태 기억하기

// point 1 ) 최소 비용 저장 배열 생성 (MAX_VALUE로 초기화)
// point 2 ) compareTo 활용 -> pq 사용 !!!
// point 3 ) visited 배열은 활용할 필요가 X

public class 녹색옷입은애가젤다지 {
	
	static int N;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int minLost;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int problemNum=0;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			problemNum++;
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			sb.append("Problem "+problemNum+": "+minLost+"\n");
		}	
		System.out.println(sb);
	}
	
	static void bfs() {
		
		// 각 칸까지의 최소 비용을 저장할 배열
		int[][] move = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(move[i], Integer.MAX_VALUE);
		}

		Queue<Loc> q = new PriorityQueue<>();
		q.add(new Loc(0,0, map[0][0]));
		move[0][0] = map[0][0];
		
		while(!q.isEmpty()) {
			
			Loc cur = q.poll();
			
			if(cur.r==N-1 && cur.c==N-1) {
				minLost = cur.lost;
				return;
			}
			
			
			for(int d=0; d<4; d++) {
				
				int nr = cur.r+ dr[d];
				int nc = cur.c+ dc[d];
				
				// 지금까지 저장된 nr, nc 칸 최소 비용보다
				// 해당 경로를 따라서 lost를 감수하고 진행하는게 더 최소비용이라면
				if(isPossible(nr, nc) && cur.lost+map[nr][nc] < move[nr][nc]) {
					move[nr][nc] = cur.lost + map[nr][nc];
					q.add(new Loc(nr,nc, move[nr][nc]));
				}
			}
		}
	}
	
	
	
	static boolean isPossible(int nr, int nc) {
		if(nr<0 || nc<0|| nr>=N || nc>=N) return false;
		return true;
	}

}

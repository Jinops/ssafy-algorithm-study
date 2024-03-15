package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Location{
	int r;
	int c;
	
	Location(int r, int c){
		this.r=r;
		this.c=c;
	}
}

public class 빙산_2573 {
	
	static int[][] arr;
	static int N, M;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year=0;
		while(true) {

			visited= new boolean[N][M];
			int areaCnt=0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!visited[i][j] && arr[i][j]>0) {
						dfs(i,j,visited);
						areaCnt++;
					}
				}
			}
			
			if(areaCnt>=2) { // 빙산이 2개 이상으로 분리된 경우
				break;
			}else if(areaCnt==0) { // 빙산이 모두 녹은 경우
				year=0;
				break;
			}
			melt();
			year++;
		}
		System.out.println(year);
	}
	
	// 빙산 한 덩어리 내의 영역 전부 방문
	public static void dfs(int r, int c, boolean[][] visited) {
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (isPossible(nr, nc)) {
				if (!visited[nr][nc] && arr[nr][nc] > 0) {
					dfs(nr, nc, visited);
				}
			}
		}
	}
	
//	public static void melt() {
//		Queue<Location> q = new LinkedList<>();
//		boolean[][] visited = new boolean[N][M];
//		
//		for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (arr[i][j] > 0) {
//                    q.add(new Location(i, j));
//                    visited[i][j] = true;
//                }
//            }
//        }
//		
//		while (!q.isEmpty()) {
//			Location ice = q.poll();
//			
//			int water = 0; // 빙산 상하좌우 물 영역 개수
//			
//			for (int i = 0; i < 4; i++) {
//				int nr = ice.r + dr[i];
//				int nc = ice.c + dc[i];
//				
//				if (isPossible(nr,nc)) {
//					if (!visited[nr][nc] && map[nr][nc] == 0) {
//						water++;
//					}
//				}
//			}
//			
//			if (arr[ice.r][ice.c] - water < 0) {
//				arr[ice.r][ice.c] = 0; // 각 칸에 저장된 높이는 0보다 더 줄어들지 않기 때문에 0보다 작아지는 경우 0을 저장
//			} else {
//				arr[ice.r][ice.c] -= water;
//			}
//		}
//	}
	
	public static void melt() {
        int[][] tempArr = new int[N][M]; // 녹는 양을 임시로 저장할 배열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0) {
                    int water = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (isPossible(nr, nc) && arr[nr][nc] == 0) {
                            water++;
                        }
                    }
                    tempArr[i][j] = water;
                }
            }
        }

        // 빙산 녹이기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] -= tempArr[i][j];
                if (arr[i][j] < 0) {
                    arr[i][j] = 0;
                }
            }
        }
    }
	
	static boolean isPossible(int nr, int nc) {
		if(nr<0 || nc<0 || nr>=N || nc>=M) return false;
		return true;
	}
}

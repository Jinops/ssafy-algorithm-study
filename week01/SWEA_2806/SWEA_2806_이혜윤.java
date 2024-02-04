package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2806_이혜윤 {
	static int[][] arr;
	static int N, cnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++){
			cnt=0; // 방법 가짓수
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			queen(0);
			System.out.println("#"+t+" "+cnt);
		}

	}
	
	// queen을 하나씩 배치하는 함수
	// q: 현재 놓아진 queen 개수
	static void queen(int q) {
		if(q==N) { 
			cnt++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(arr[q][i] != 0) {
				continue;
			}
			ChessUpdate(q,i,1); // chess 배치 못하는 칸에 표시
			queen(q+1);
			ChessUpdate(q,i,-1); // 초기화
		}
	}
	
	// chess를 배치 못하는 칸은 +1, 초기화할 때마다 -1
	static void ChessUpdate(int row, int col, int option) {
		for (int i = 0; i < N; i++) {
			arr[i][col] += option;
			arr[row][col] += option;
		}

		for (int x = row, y = col; isOnBoard(x, y); x++, y++) {
			arr[x][y] += option;
		}
		for (int x = row, y = col; isOnBoard(x, y); x++, y--) {
			arr[x][y] += option;
		}
		for (int x = row, y = col; isOnBoard(x, y); x--, y++) {
			arr[x][y] += option;
		}
		for (int x = row, y = col; isOnBoard(x, y); x--, y--) {
			arr[x][y] += option;
		}

		arr[row][col] -= option * 5;
	}
	
	// 체스판 범위 안에 있는지
	static boolean isOnBoard(int row, int col) {
		return row>=0 && row<N && col>=0 && col<N ? true: false;
	}
}

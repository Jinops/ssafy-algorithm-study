import java.util.Scanner;
 
public class SWEA_4615_배준영 {
    static int[][] board;
 
    static int x;
    static int y;
    static int color; // 1 : b , 2 : w;
    // 상 하 좌 우 좌상 우하 우상 좌하
    static int[] dx = { -1, 1, 0, 0, -1, 1, -1, 1 };
    static int[] dy = { 0, 0, -1, 1, -1, 1, 1, -1 };
 
    static int black;
    static int white;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
 
            board = new int[N][N];
            board[N / 2 - 1][N / 2 - 1] = 2;
            board[N / 2][N / 2] = 2;
            board[N / 2 - 1][N / 2] = 1;
            board[N / 2][N / 2 - 1] = 1;
 
            black = 2;
            white = 2;
 
            for (int i = 0; i < M; i++) {
 
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
                color = sc.nextInt();
                if (color == 1) {
                    black++;
                } else {
                    white++;
                }
 
                board[x][y] = color;
                check(N, x, y);
            }
            System.out.printf("#%d %d %d\n",tc, black, white);
        }
 
    }
 
    static void check(int N, int x, int y) {
        for (int d = 0; d < 8; d++) {
            int ndx = x + dx[d];
            int ndy = y + dy[d];
 
            while (ndx >= 0 && ndx < N && ndy >= 0 && ndy < N && board[ndx][ndy] != 0
                    && board[x][y] != board[ndx][ndy]) {
                ndx = ndx + dx[d];
                ndy = ndy + dy[d];
            }
 
            if (ndx >= 0 && ndx < N && ndy >= 0 && ndy < N && board[ndx][ndy] != 0 && board[x][y] == board[ndx][ndy]) {
                ndx = ndx - dx[d];
                ndy = ndy - dy[d];
 
                if (d == 0 || d == 1) {
                    while (ndx != x) {
                        reverse(ndx, ndy);
                        ndx = ndx - dx[d];
                        ndy = ndy - dy[d];
                    }
                } else {
                    while (ndy != y) {
                        reverse(ndx, ndy);
                        ndx = ndx - dx[d];
                        ndy = ndy - dy[d];
                    }
 
                }
            }
 
        }
    }
 
    static void reverse(int x, int y) {
        if (board[x][y] == 1) {
            board[x][y] = 2;
            black--;
            white++;
        } else if (board[x][y] == 2) {
            board[x][y] = 1;
            black++;
            white--;
        }
    }
}
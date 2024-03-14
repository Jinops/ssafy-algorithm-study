import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_2573 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int iceNum = 0; // 빙산 개수
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int time = 0;
    static int currentIce;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] != 0) {
                    iceNum++;
                }
            }
        }
        Loop: for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                while (map[r][c] > 0) {
                    visited = new boolean[n][m];
                    currentIce = 0;
                    dfs(r, c);
                    if (currentIce != iceNum) {
                        break Loop;
                    }
                    afterTime();
                }
            }
        }
        if (iceNum == 0) {
            System.out.println(0);
        } else {
            System.out.println(time);
        }


    }
    private static void afterTime() {
        time++;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp[i] = map[i].clone();
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] > 0) {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (isIn(nr, nc)) {
                            if (map[nr][nc] == 0) {
                                tmp[r][c]--;
                            }
                        }
                    }
                    if (tmp[r][c] <= 0) {
                        tmp[r][c] = 0;
                        iceNum--;
                    }
                }
            }
        }
        map = tmp;
    }

    private static boolean isIn(int nr, int nc) {
        if (nr < 0 || nr >= n || nc < 0 || nc >= m)
            return false;
        return true;
    }

    private static void dfs(int r, int c) {
        currentIce++;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isIn(nr, nc) && !visited[nr][nc] && (map[nr][nc] > 0)) {
                dfs(nr, nc);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.
 */
public class BAEK_4963 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken()); // column
        int h = Integer.parseInt(st.nextToken()); // row
        map = new int[h][w];
        visited = new boolean[h][w];
        while (w != 0 || h != 0) {
            for (int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < w; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            int islandCnt = 0;
            for (int r = 0; r < h; r++) {
                for (int c = 0; c < w; c++) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        islandCnt++;
                        dfs(r, c);
                    }
                }
            }
            sb.append(islandCnt).append("\n");
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];
        }
        System.out.print(sb);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isOut(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    private static boolean isOut(int r, int c) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[r].length)
            return true;
        return false;
    }
}

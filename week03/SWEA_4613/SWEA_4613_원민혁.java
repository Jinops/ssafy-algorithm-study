import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_러시아국기같은깃발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] colors = new int[N][3];
            for (int n = 0; n < N; n++) {
                String str = br.readLine();
                for (int m = 0; m < M; m++) {
                    if (str.charAt(m) == 'W')
                        colors[n][0]++;
                    else if (str.charAt(m) == 'B')
                        colors[n][1]++;
                    else
                        colors[n][2]++;
                }
            }
            int minCount = Integer.MAX_VALUE; // 최소 변경 횟수 변수
            for (int b = 1; b < N-1; b++) { // blue의 시작 행 위치
                for (int c = b; c < N-1; c++) { // blue의 마지막 행 위치
                    int count = 0;
                    for (int i = 0; i < N; i++) {
                        if (i < b)
                            count += (colors[i][1] + colors[i][2]);
                        else if (i > c)
                            count += (colors[i][0] + colors[i][1]);
                        else
                            count += (colors[i][0] + colors[i][2]);
                    }
                    if (minCount > count)
                        minCount = count;
                }
            }
            sb.append("#"+t+" "+minCount+"\n");
        }
        System.out.println(sb);
    }
}

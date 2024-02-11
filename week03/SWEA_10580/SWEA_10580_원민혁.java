import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10580_전봇대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] poleMap = new int[N][2];
            for (int n = 0; n < N; n++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                poleMap[n][0] = Integer.parseInt(st.nextToken());
                poleMap[n][1] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    if (poleMap[i][0] < poleMap[j][0] && poleMap[i][1] > poleMap[j][1])
                        count++;
                    else if (poleMap[i][0] > poleMap[j][0] && poleMap[i][1] < poleMap[j][1])
                        count++;
                }
            }
            sb.append("#"+t+" "+count+"\n");
        }
        System.out.println(sb);
    }
}


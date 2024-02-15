import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10580_������ {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            
//            ������ ����
            int N = Integer.parseInt(br.readLine());
            int[][] sun = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
//                i�� index�� �ش��ϴ� ������ ���� ��ǥ
                sun[i][0] = Integer.parseInt(st.nextToken());
//                i�� index�� �ش��ϴ� ������ ���� ��ǥ
                sun[i][1] = Integer.parseInt(st.nextToken());
            }
            
            int cnt = 0;
            for (int r = 0; r < N - 1; r++) {
                for (int i = r + 1; i < N; i++) {
                    if ((sun[r][0] - sun[i][0]) * (sun[r][1] - sun[i][1]) < 0) cnt++;
                }
            }
            
            System.out.println("#" + t + " " + cnt);
        }
    }
}
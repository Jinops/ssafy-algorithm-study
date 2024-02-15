import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_������ {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
//            W, B, R�� ǥ���� ������ �迭 map
            char[][] map = new char[N][M];
//            r��° index�� �ش��ϴ� �ٿ� �ִ� W, B, R�� ������ ���� color[r][0], color[r][1], color[r][2]�� ����
            int[][] color = new int[N][3];
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < M; c++) {
                    map[r][c] = str.charAt(c);
                    if (map[r][c] == 'W') color[r][0]++;
                    else if (map[r][c] == 'B') color[r][1]++;
                    else color[r][2]++;
                }
            }
            
//            color�迭�� �������� ������ �迭 colorStack
            int[][] colorStack = new int[N][3];
            colorStack[0][0] = color[0][0];
            colorStack[0][1] = color[0][1];
            colorStack[0][2] = color[0][2];
            for (int r = 1; r < N; r++) {
                colorStack[r][0] = colorStack[r - 1][0] + color[r][0];
                colorStack[r][1] = colorStack[r - 1][1] + color[r][1];
                colorStack[r][2] = colorStack[r - 1][2] + color[r][2];
            }
            
            int A = 0, B = 0, C = 0;
            int max = 0;
            for (int r1 = 0; r1 < N - 2; r1++) {
//                A = 0�� index�� �ش��ϴ� row���� r1�� index�� �ش��ϴ� row���� W�� ����
                A = colorStack[r1][0];
                for (int r2 = r1 + 1; r2 < N - 1; r2++) {
//                    B = (r1 + 1)�� index�� �ش��ϴ� row���� r2�� index�� �ش��ϴ� row���� B�� ����
                    B = colorStack[r2][1] - colorStack[r1][1];
//                    C = (r2 + 1)�� index�� �ش��ϴ� row���� (N - 1)��(=������) index�� �ش��ϴ� row���� R�� ���� 
                    C = colorStack[N - 1][2] - colorStack[r2][2];
//                    A + B + C�� ���� ũ�� Ŭ���� ĥ�ؾ��ϴ� W, B, R�� ������ �پ���.
                    if (max < A + B + C) max = A + B + C;
                }
            }
            
            int min = N * M - max;
            System.out.println("#" + t + " " + min);
        }
    }
}
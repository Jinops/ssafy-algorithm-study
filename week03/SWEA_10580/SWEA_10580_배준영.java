import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
// 전봇대
public class SWEA_10580_배준영 {
 
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
             
            int N = Integer.parseInt(br.readLine());
            int[][] lines = new int[N][2];
            for(int i=0; i<N; i++) {
                String[] input = br.readLine().split(" ");
                lines[i][0] = Integer.parseInt(input[0]);
                lines[i][1] = Integer.parseInt(input[1]);
            }
             
            Arrays.sort(lines, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
             
            int cnt=0;
             
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    if(lines[j][1] < lines[i][1]) {
                        cnt++;
                    }
                }
            }
 
            System.out.printf("#%d %d\n", tc, cnt);
             
        }
                 
         
    }
}
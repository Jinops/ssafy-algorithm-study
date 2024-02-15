import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 러시아 국기 같은 깃발
public class SWEA_4613_배준영 {
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
             
            int[][] flagColor = new int[N][3];
            for(int i=0; i<N; i++) {
                String line = br.readLine();
                for(int j=0; j<M; j++) {
                    if(line.charAt(j)=='W') {
                        flagColor[i][0]++;
                    }
                    else if(line.charAt(j)=='B') {
                        flagColor[i][1]++;
                    }
                    else {
                        flagColor[i][2]++;
                    }
                }
            }
             
            // W B R
            int min = Integer.MAX_VALUE;
             
            // 흰색 x -> N-2 가지 (파랑색을 결정)
            // 흰색 1 -> N-3 가지 
             
             
            for(int i=0; i<N-2; i++) {
                int sum = 0;
             
                for(int k=0; k<=i; k++) {
                    sum += flagColor[k][1];
                    sum += flagColor[k][2];
                }
                 
                for(int j=i+1; j<N-1; j++) {
                    int checkSum = 0;
                    for(int k=i+1; k<=j; k++) {
                        checkSum += flagColor[k][0];
                        checkSum += flagColor[k][2];
                    }
                    for(int k=j+1; k<N; k++) {
                        checkSum += flagColor[k][0];
                        checkSum += flagColor[k][1];
                    }
                     
                     
                     
                    if(sum+checkSum < min) {
                        min = sum+checkSum;
                    }
                }
            }           
            System.out.printf("#%d %d\n", tc, min);
        }
         
    }
}
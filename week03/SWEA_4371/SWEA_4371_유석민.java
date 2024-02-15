import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4371_유석민 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            
            int N = Integer.parseInt(br.readLine());
            int[] gDay = new int[N];
            int[] checkDay = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                gDay[i] = Integer.parseInt(br.readLine()) - 1;
                checkDay[i] = gDay[i];
                sum += checkDay[i];
//                System.out.println(sum);
            }
            
//            배수체크 >> 나머지가 0인 것으로 접근
            int idx = 0;
            int cnt = 0;
            boolean flag = true;
            while (flag) {
                
                idx++;
                if (checkDay[idx] == 0) continue;
                cnt++;
                for (int i = idx; i < N; i++) {
                    if (gDay[i] % gDay[idx] == 0) {
                        sum -= gDay[i];
                        checkDay[i] = 0;
                        if (sum == 0) flag = false;
//                        System.out.println("sum : " + sum + " idx : " + idx);
                    }
                }
            }
            
            System.out.println("#" + t + " " + cnt);
        }
    }
}
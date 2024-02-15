import java.io.IOException;
import java.util.Scanner;
// 항구에 들어오는 배
public class SWEA_4371_배준영 {
     
    static int sum(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum+=arr[i];
        }
         
        return sum;
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
 
            //List<Integer> days = new ArrayList<>();
            int[] days = new int[N];
 
            for (int i = 0; i < N; i++) {
                days[i]  = sc.nextInt() - 1;
            }
            days[0] = 1;
            int cnt = 0;
            boolean isShip = false;
            for(int i=1; i<N-1; i++) {   
                isShip = false;
                for(int j=i; j<N; j++) {
                    if(days[i] != 0 && days[j]%days[i] == 0) {
                        isShip = true;
                        if(j!=i) {
                            days[j] = 0;
                        }
                    }
                }
                days[i] = 0;
                if(isShip) {
                    cnt++;
                }
            }
            if(days[N-1] != 0) {
                cnt++;
            }
             
             
            System.out.printf("#%d %d\n", tc, cnt);
        }
 
    }
}
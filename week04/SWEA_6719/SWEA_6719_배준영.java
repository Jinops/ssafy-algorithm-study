import java.util.Arrays;
import java.util.Scanner;
 
public class SWEA_6719_배준영 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
 
            int N = sc.nextInt();
            int K = sc.nextInt();
 
            int[] courses = new int[N];
 
            for (int i = 0; i < N; i++) {
                courses[i] = sc.nextInt();
            }
 
            Arrays.sort(courses);
            System.out.printf("#%d %f\n", tc, registration(courses, courses.length, K));
 
        }
    }
 
    // M_n = K_1/2^n + K_2/2^(n-1) + ... + K_n/2
    static double registration(int[] arr, int N, int K) {
        if (N == arr.length - K + 1) {
            return arr[N - 1] / Math.pow(2, arr.length - N + 1);
        } else {
            return arr[N - 1] / Math.pow(2, arr.length - N + 1) + registration(arr, N - 1, K);
        }
 
    }
}
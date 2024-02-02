// WIP
import java.util.*;

public class Main {
    static int N;
    static int result;

    static boolean[][] getM(boolean[][] m, int x, int y){
        boolean[][] newM = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j==x || i==y){
                    newM[i][j] = true;
                } else {
                    newM[i][j] = m[i][j];
                }
            }
        }
        for(boolean[] a:newM){
            System.out.println(Arrays.toString(a));
        }
        return newM;
    }
    static void queen(boolean[][] m, int y, int cnt){
        if(cnt==N){
            System.out.println("done\n");
            result += 1;
            return;
        }
        for(int i=y; i<N; i++){
            for(int j=0; j<N; j++){
                if(m[i][j]){
                    continue;
                }
                System.out.println(i+", "+j);

                for(boolean[] a:m){
                    System.out.println(Arrays.toString(a));
                }
                System.out.println("----");
                queen(getM(m, j, i), i+1+cnt, i+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        boolean[][] m = new boolean[N][N]; // 퀸 올릴 수 있으면 false

        queen(m, 0, 0);
        System.out.println(result);
    }
}   


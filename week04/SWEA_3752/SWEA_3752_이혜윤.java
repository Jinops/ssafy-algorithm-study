package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 가능한시험점수_3752 {
     
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] arr; //배점 저장
    static boolean[] score; //점수 가능 여부 저장
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr= new int[N];
            st = new StringTokenizer(br.readLine());
            int sum=0;
            for(int n=0; n<N; n++) {
                arr[n] = Integer.parseInt(st.nextToken());
                sum += arr[n]; // 최대 점수 계산을 위한 sum 누적
            }
             
            score = new boolean[sum+1]; // 최소 0점이므로 0-based
            score[0] = true;
//          dfs(0, 0);
             
            for(int num: arr) {
                for(int i=sum; i>=num; i--) {
                    score[i] = score[i] || score[i-num];
                }
            }
             
             
            int res=0;
            for(int i=0; i<score.length; i++) {
                if(score[i]) res++;
            }
            sb.append("#"+t+" "+res+"\n");
        }
        System.out.println(sb);
    }
     
//  시간 복잡도 오류
//  static void dfs(int currentScore, int nextIdx) {
//      int nextScore = arr[nextIdx]; 
//      score[currentScore+nextScore]=true; // 가능여부 처리
//      
//      nextIdx++;
//      if(nextIdx==N) return;
//      
//      dfs(currentScore, nextIdx);
//      dfs(currentScore+nextScore, nextIdx);
//  }
}

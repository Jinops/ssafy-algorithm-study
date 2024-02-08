import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    
    for(int t=1; t<=T; t++) {
      int result = 0;
      int N = Integer.parseInt(br.readLine());
      int Nsquare = N*N;
      
      for(int y=1; y<=N; y++) {
        for(int x=1; x<=N; x++) {
          if((x*x)+(y*y)<=Nsquare) {
            result += 1;
          }
        }
      }
      result *= 4; // 사분면 4개
      
      result += 1; // 원점
      result += N*4; // x축, y축 위 점
      
      
      System.out.printf("#%d %d\n", t, result);
    }
  }
}

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int T = Integer.parseInt(br.readLine());
    for(int t=1; t<=T; t++) {

      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int nums[] = new int[N];
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
      }
      
      int max = -1;
      for(int i=0; i<N-1; i++) {
        for(int j=i+1; j<N; j++) {
          int sum = nums[i] + nums[j];
          if(max<=sum && sum<=M) {
            max = sum;
          }
        }
      }
      
      System.out.printf("#%d %d\n", t, max);
    }
  }
}

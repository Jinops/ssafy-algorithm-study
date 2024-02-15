import java.io.*;
import java.util.*;
 
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    for (int t=1; t<=T; t++) {
      
      int N = Integer.parseInt(br.readLine());
      int[] lefts = new int[N];
      int[] rights = new int[N];
      int result = 0;
      
      for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        lefts[i] = Integer.parseInt(st.nextToken());
        rights[i] = Integer.parseInt(st.nextToken());
      }
      
      for(int i=0; i<N; i++) {
        for(int j=i+1; j<N; j++) {
          if((lefts[i]<lefts[j] && rights[j]<rights[i])
          || (lefts[i]>lefts[j] && rights[j]>rights[i])) {
            result++;
          }
        }
      }
      
      System.out.printf("#%d %d\n", t, result);
    }
  }
}

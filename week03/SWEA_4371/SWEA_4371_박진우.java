import java.io.*;
import java.util.*;
 
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t=1; t<=T; t++) {
      
      int N = Integer.parseInt(br.readLine());
      int[] days = new int[N];
      Set<Integer> set = new HashSet<>();

      days[0] = Integer.parseInt(br.readLine());
      for(int i=1; i<N; i++) {
        int diff = Integer.parseInt(br.readLine()) - 1;
        boolean isNewPattern = true;
        for(int n:set) {
          if(diff%n==0) {
            isNewPattern = false;
            break;
          }
        }
        if(isNewPattern) {
          set.add(diff);
        }
      }
      
      System.out.printf("#%d %d\n", t, set.size());
    }
  }
}

import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    
    for(int t=1; t<=T; t++) {
      int N = Integer.parseInt(br.readLine());
      boolean[] hasAlphabets = new boolean['Z'-'A'+1];
      
      for(int i=0; i<N; i++) {
        hasAlphabets[br.readLine().charAt(0)-'A'] = true;
      }
      
      int result = 0;
      for(boolean hasAlphabet:hasAlphabets) {
        if(!hasAlphabet) {
          break;
        } else {
          result += 1;
        }
      }
      
      System.out.printf("#%d %d\n", t, result);
    }
  }
}

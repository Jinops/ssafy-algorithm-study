import java.io.*;
import java.util.*;

public class Solution {
  static int result;
  static int feeMs[];
  static int feeQ;
  
  static void pick(int m, int acc) {
    if(m>12 || acc>result) {
      return;
    }
    if(m==12) {
      result = Math.min(result, acc);
      return;
    }
    
    pick(m+1, acc+feeMs[m]);
    pick(m+3, acc+feeQ);
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int T = Integer.parseInt(br.readLine());
    for(int t=1; t<=T; t++) {
      
      st = new StringTokenizer(br.readLine());
      int feeD = Integer.parseInt(st.nextToken());
      int feeM = Integer.parseInt(st.nextToken());
      feeQ = Integer.parseInt(st.nextToken());
      int feeY = Integer.parseInt(st.nextToken());
      
      feeMs = new int[12];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<12; i++) {
        int day = Integer.parseInt(st.nextToken());
        if(day>0) {
          feeMs[i] = Math.min(feeD*day, feeM);          
        }
      }
      
      result = feeY;
      pick(0, 0);
      
      System.out.printf("#%d %d\n", t, result);
    }
  }
}

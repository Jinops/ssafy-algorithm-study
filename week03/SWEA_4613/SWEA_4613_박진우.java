import java.io.*;
import java.util.*;

public class Solution {
  
  static int count(String str, char target) {
    int count = 0;
    for(char c:str.toCharArray()) {
      if(c==target) count++;
    }
    return count;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    
    for(int t=1; t<=T; t++) {
      
      st = new StringTokenizer(br.readLine());
      int result = 0;
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int[] wCnts = new int[N-2];
      int[] bCnts = new int[N-2];
      int[] rCnts = new int[N-2];
      
      result += M - count(br.readLine(), 'W');
      for(int i=0; i<N-2; i++) {
        String line = br.readLine();
        wCnts[i] = count(line, 'W');
        bCnts[i] = count(line, 'B');
        rCnts[i] = count(line, 'R');
      }
      result += M - count(br.readLine(), 'R');
      
      int midResult = (N-2) * M;
      for(int bSize=1; bSize<=N-2; bSize++) {
        for(int bFrom=0; bFrom+bSize<=N-2; bFrom++) {
          int temp = 0;
          for(int i=0; i<bFrom; i++) {
            temp += M - wCnts[i]; // white
          }
          for(int i=bFrom; i<bFrom+bSize; i++) {
            temp += M - bCnts[i]; // blue
          }
          for(int i=bFrom+bSize; i<N-2; i++) {
            temp += M - rCnts[i]; // red
          }
          midResult = Math.min(midResult, temp);
        }
      }
      result += midResult;
      
      System.out.printf("#%d %d\n", t, result);
    }
  }
}

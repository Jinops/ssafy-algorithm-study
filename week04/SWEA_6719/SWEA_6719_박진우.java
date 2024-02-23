import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int t=1; t<=T; t++) {

      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      ArrayList<Integer> arr = new ArrayList<>();
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++) {
        arr.add(Integer.parseInt(st.nextToken()));
      }
      arr.sort(null);
      double result = 0;
      for(int i=N-K; i<N; i++) {
        result = (result+arr.get(i))/2;
      }

      System.out.printf("#%d %f\n", t, result);
    }
  }
}

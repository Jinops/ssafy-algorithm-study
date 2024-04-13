import java.util.*;
import java.io.*;

// N명 M개 블록 (높이가 다름)

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      List<Integer> values = new ArrayList<>();
      while(st.hasMoreTokens()) {
        values.add(Integer.parseInt(st.nextToken()));
      }
      map.put(i, values);
    }
    
    int dp[] = new int[H+1]; 
    // H를 만들기 위한 경우의 수
    
    for(int i=0; i<N; i++) {
      // i번 학생까지 고려했을 때
      // 1. 내가 가진 값으로 바로 H 만드는 경우
      // 2. i-1번까지 학생의 값 조합으로 H 만드는 경우
      int[] adds = new int[H+1];
      for(int block:map.get(i)) {
        for(int h=block+1; h<=H; h++) {
          adds[h] += dp[h-block] % 10007;
          adds[h] %= 10007;
        }
      }
      for(int block:map.get(i)) {
        dp[block] += 1;
        dp[block] %= 10007;
      }
      for(int h=1; h<=H; h++) {
        dp[h] += adds[h] % 10007;
        dp[h] %= 10007;
      }
    }
    
    System.out.println(dp[H]);
  }
}

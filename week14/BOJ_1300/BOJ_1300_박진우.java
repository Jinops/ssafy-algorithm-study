import java.util.*;
import java.io.*;

public class Main {
  static int N;
  
  static long getCnt(long target) {
    // target 이하인 숫자의 개수
    long cnt = 0;
    for(int i=1; i<=N; i++) {
      cnt += Math.min(target/i, N);
    }
    return cnt;
  }
  
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    int K = sc.nextInt();
    
    long left = 1;
    long right = K;
    
    while(left <= right) {
      long mid = (left+right)/2;
      long cnt = getCnt(mid);

      if(cnt==K) {
        break;
      }
      if(cnt < K) {
        left = mid+1;
      } else {
        right = mid-1;
      } 
    }
    
    System.out.println(left);
  }
}

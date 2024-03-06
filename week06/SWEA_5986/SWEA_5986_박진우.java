import java.io.*;
import java.util.*;

public class Solution {
  static int[] primes;
  static int validCnt;
  
  static void pick(int idx, int cnt, int acc) {
    if(cnt==3) {
      if(acc==0) {
        validCnt++;
      }
      return;
    }
    for(int i=idx; i<primes.length; i++) {
      if(acc>=primes[i]) {
        pick(i, cnt+1, acc-primes[i]);        
      }
    }
  }
  
  static boolean isPrime(int n) {
    for(int i=2; i*i<=n; i++) {
      if(n%i==0) return false;
    }
    return true;
  }
  static int[] getPrimes(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=2; i<=n; i++) {
      if(isPrime(i)) list.add(i);
    }
    return list.stream().mapToInt(i->i).toArray();
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T = Integer.parseInt(br.readLine());
    for(int t=1; t<=T; t++) {
      
      int N = Integer.parseInt(br.readLine());
      primes = getPrimes(N);
      validCnt = 0;
      
      pick(0, 0, N);
      
      System.out.printf("#%d %d\n", t, validCnt);
    }
  }
}

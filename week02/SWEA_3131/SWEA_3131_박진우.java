import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution {
  static boolean isPrime(int n) {
    for(int i=2; i*i<=n; i++) {
      if (n%i==0) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = 1000001;
    Boolean[] isPrimes = new Boolean[N]; // Array of Null

    for(int i=2; i<N; i++) {
      if(isPrimes[i]==null) {
        isPrimes[i] = isPrime(i);
      }
      if(isPrimes[i]) {
        bw.append(i + " ");
      } else {
        for(int j=2; i*j<=N; j++) {
          isPrimes[i*j] = false;
        }
      }
    }
    
    bw.flush();
    bw.close();
  }
}

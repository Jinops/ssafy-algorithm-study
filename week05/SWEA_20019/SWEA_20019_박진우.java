import java.io.*;
import java.util.*;

public class Solution {
  static boolean isPalindrome(String str) {
    for(int i=0; i<str.length()/2; i++) {
      if(str.charAt(i) != str.charAt(str.length()-1-i)) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int T = Integer.parseInt(br.readLine());
    for(int t=1; t<=T; t++) {

      String str = br.readLine();
      boolean isPal = isPalindrome(str) && isPalindrome(str.substring(0, str.length()/2));
      
      System.out.printf("#%d %s\n", t, isPal?"YES":"NO");
    }
  }
}

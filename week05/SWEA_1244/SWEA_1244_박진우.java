import java.io.*;
import java.util.*;

public class Solution {
  static int remainCnt;
  
  static int getDescendingCount(int[] arr, int idx) {
    int cnt = 1;
    int i = idx;
    while(i<arr.length-2 && arr[i]>arr[++i]) {
      cnt++;
    }
    return cnt;
  }
  
  static int getContinuousCount(int[] arr, int idx) {
    int cnt = 1;
    int i = idx;
    while(i>0 && arr[--i]==arr[idx]) {
      cnt++;
    }
    return cnt;
  }
  
  static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
    remainCnt--;
  }
  
  static int getMaxIdx(int[] arr, int start) {
    int maxIdx = start;
    for(int i=start+1; i<arr.length; i++) {
      if(arr[i]>=arr[maxIdx]) { // last idx
        maxIdx = i;
      }
    }
    return maxIdx;
  }
  
  static String toString(int[] arr) {
    StringBuilder sb = new StringBuilder();
    for(int n:arr) {
      sb.append(n);
    }
    return sb.toString();
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int T = Integer.parseInt(br.readLine());
    for(int t=1; t<=T; t++) {

      st = new StringTokenizer(br.readLine());
      String str = st.nextToken();
      int[] arr = new int[str.length()];
      remainCnt = Integer.parseInt(st.nextToken());
      
      for(int i=0; i<arr.length; i++) {
        arr[i] = Character.getNumericValue(str.charAt(i));
      }
      
      int baseIdx = 0;
      int continuous = 0;

      
      if(arr.length == 2) {
        if(remainCnt%2==1) {
          swap(arr, baseIdx, baseIdx+1);
        }
        remainCnt = 0;
      }
      
      while(remainCnt>0) {
        if(baseIdx == arr.length-2) {
          int targetIdx = arr[baseIdx-1]<=arr[baseIdx] ? baseIdx-1 : baseIdx+1;
          swap(arr, baseIdx, targetIdx);
          continue;
        }
        int targetIdx = getMaxIdx(arr, baseIdx+1);
        if(arr[baseIdx]>=arr[targetIdx]) {
          baseIdx++;
          continue;
        }
        
        continuous = getContinuousCount(arr, targetIdx);
        if(continuous > 1  && arr[baseIdx]>arr[baseIdx+1]) {
          int desc = getDescendingCount(arr, baseIdx);
          int swapCnt = Math.min(remainCnt, Math.min(desc, continuous));
          for(int i=0; i<swapCnt; i++) {
            swap(arr, baseIdx+i, targetIdx-swapCnt+1+i);
          }
          baseIdx += swapCnt;
          continue;
        } 
        
        swap(arr, baseIdx, targetIdx);
      }
      
      System.out.printf("#%d %s\n", t, toString(arr));
    }
  }
}

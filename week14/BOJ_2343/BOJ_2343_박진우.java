// 블루레이의 크기에 대해 이분탐색 시행
// 해당 크기에 모든 블루레이를 넣었을  때 만들어지는 개수가
// M과 일치하면 종료

import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int M;
  static int[] nums;

  static int find(int start, int end) {
    while(start < end) {
      int mid = (start+end) / 2; // 블루레이의 크기
      int cnt = getCount(mid);// mid 크기의 블루레이를 사용한 결과
      
      if(cnt > M) {
        // 목표 M보다 개수가 많아졌다면
        start = mid + 1; // 크기를 키워간다.
      } else {
        // 목표와 일치하거나 더 다면
        end = mid; // 크기를 줄여간다
      }
    }
    return start;
  }
  
  static int getCount(int size) {
    int cnt = 0; // 사용한 블루레이 개수
    int cur = 0; // 현재 블루레이의 남은 공간
    
    for(int num:nums) {
      if(num>cur) {
        // 현재 블루레이에 num을 넣을 수 없다면 블루레이 새로 할당
        cnt++;
        cur = size;
      }
      cur -= num;
    }
    
    return cnt;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    nums = new int[N];
    
    st = new StringTokenizer(br.readLine());
    
    int max = 0;
    int sum = 0;
    for(int i=0; i<N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, nums[i]);
      sum += nums[i];
    }
    
    System.out.println(find(max, sum));
  }
}

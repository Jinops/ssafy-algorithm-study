import java.util.*;
import java.io.*;

class Main {
  static int N;
  static int K;
  static boolean[] isRobots;
  static int[] hps;
  
  static int in;
  static int out;
  
  static void initInOut() {
    in = 1;
    out = N;
  }
  
  static boolean isValid() {
    int cnt = 0;
    for(int i=1; i<=2*N; i++) {
      if(hps[i]==0) cnt++;
    }
    
    return !(cnt>=K);
  }
  
  static void rotate() {
    in = (in==1) ? 2*N : in-1;
    out = (out==1) ? 2*N : out-1;
  }
  
  static void outIfPossible() {
    if(isRobots[out]) isRobots[out] = false;
  }
  
  static void inIfPossible() {
    if(hps[in]>0) {
      isRobots[in] = true;
      hps[in] -= 1;
    }
  }
  
  static void robotMove() {
    int to = out;
    int cnt = N-2;
    
    while(cnt-->0) {
      int from = to-1;
      if(from==0) from = 2*N;
      if(isRobots[from] && !isRobots[to] && hps[to]>0) {
        isRobots[from] = false;
        isRobots[to] = true;
        hps[to] -= 1;
      }
      to = from;
    }
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    
    isRobots = new boolean[2*N+1]; // 로봇 있는지 여부
    hps = new int[2*N+1];
    
    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=2*N; i++) {
      hps[i] = Integer.parseInt(st.nextToken());
    }
    
    int stage = 0;
    initInOut();
    
    while(isValid()) {
      stage++;
      rotate();
      outIfPossible();
      robotMove();
      outIfPossible();
      inIfPossible();
    }
    
    System.out.println(stage);
  }
}

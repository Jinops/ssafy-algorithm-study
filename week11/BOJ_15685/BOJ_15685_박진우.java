import java.io.*;
import java.util.*;

public class Main {
  static int[][] ds = new int[][] {{1,0}, {0,-1}, {-1,0}, {0,1}};
  // 우 상 좌 하 
 
  static int getCWdir(int i) {
    return (i<3) ? i+1 : 0;
  }
  
  public static void main(String[] args) throws IOException {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;
	  
	  int N = Integer.parseInt(br.readLine());
	  boolean[][] mtx = new boolean[101][101];
	  
	  for(int i=0; i<N; i++) {
	    st = new StringTokenizer(br.readLine());
	    int X = Integer.parseInt(st.nextToken());
	    int Y = Integer.parseInt(st.nextToken());
	    int D = Integer.parseInt(st.nextToken());
	    int G = Integer.parseInt(st.nextToken());
	    
	    List<Integer> dirs = new ArrayList<>();
	    
	    // 초기점 설정
	    int x = X;
	    int y = Y; 
	    mtx[y][x] = true;
	    // 0세대 커브
	    dirs.add(D);
	    x += ds[D][0];
	    y += ds[D][1];
        mtx[y][x] = true;
	    
	    while(G-->0) {
	      for(int j=dirs.size()-1; j>=0; j--) {
	        int nextDir = getCWdir(dirs.get(j));
	        dirs.add(nextDir);
	        x += ds[nextDir][0];
            y += ds[nextDir][1];
            mtx[y][x] = true;
	      }
	    }
	  }
	  
	  int result = 0;
	  for(int i=0; i<100; i++) {
	    for(int j=0; j<100; j++) {
	      if(mtx[i][j] && mtx[i+1][j] && mtx[i][j+1] && mtx[i+1][j+1]) {
	        result += 1;
	      }
	    }
	  }
	  System.out.println(result);
  }
}

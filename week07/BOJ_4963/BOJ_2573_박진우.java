import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
  static int N;
  static int M;
  static int[][] matrix;
  
  static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
  
  static boolean isWater(int x, int y) {
    return inRange(x, y) && matrix[y][x] == 0;
  }
  
  static boolean inRange(int x, int y) {
    return 0<=x&&x<M && 0<=y&&y<N;
  }
  
  static ArrayList<Point> ices = new ArrayList<>();
  static boolean isOne() {
    Point root = ices.get(0);
    int islandSize = 0;
    
    Stack<Point> stack = new Stack<>();
    boolean[][] visited = new boolean[N][M];
    
    stack.add(root);
    visited[root.y][root.x] = true; 
    
    while(!stack.isEmpty()) {
      Point p = stack.pop();
      islandSize++;
      for(int[] d:deltas) {
        Point np = new Point(p.x+d[0], p.y+d[1]);
        if(inRange(np.x, np.y) && matrix[np.y][np.x]>0 && !visited[np.y][np.x]) {
          stack.add(np);
          visited[np.y][np.x] = true; 
        }
      }
    }
    
    return ices.size()==islandSize;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken()); // 행
    M = Integer.parseInt(st.nextToken()); // 열
    matrix = new int[N][M];
    
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
        if(matrix[i][j]>0) ices.add(new Point(j, i));
      }
    }
    
    int year = 0;
    while(isOne()) {
      year++;
      
      for(Point ice:ices) {
        int reduceCnt = 0;
        for(int[] d:deltas) {
          if(isWater(ice.x+d[0], ice.y+d[1])) {
            reduceCnt++;
          }
        }
        
        matrix[ice.y][ice.x] -= reduceCnt;
        if(matrix[ice.y][ice.x]<=0) {
          matrix[ice.y][ice.x]= -1; 
        }
      }
      
      for(int i=ices.size()-1; i>=0; i--) {
        Point ice = ices.get(i);
        if(matrix[ice.y][ice.x]==-1) {
          matrix[ice.y][ice.x] = 0;
          ices.remove(i);
        }
      }
      
      if(ices.size() == 0) {
        year = 0;
        break;
      }
    }
    
    System.out.println(year);
  }
}

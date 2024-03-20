import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
  static int N;
  static int M;
  static int[][] matrix;
  static int result = 0;
  
  static boolean inRange(Point p) {
    return 0<=p.x&&p.x<M && 0<=p.y&&p.y<N;
  }
  
  static void check(Point start) {
    Queue<Point> queue = new LinkedList<>();
    int[][] depths = new int[N][M];
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        depths[i][j] = -1;
      }
    }
    queue.add(start);
    depths[start.y][start.x] = 0; 
    
    while(!queue.isEmpty()) {
      Point p = queue.poll();
      int depth = depths[p.y][p.x];
      if(matrix[p.y][p.x]==1) {
        result = Math.max(result, depth);
        break;
      }
      for(int[] d:deltas) {
        Point np = new Point(p.x+d[0], p.y+d[1]);
        if(inRange(np) && depths[np.y][np.x] == -1) {
          queue.add(np);
          depths[np.y][np.x] = depth+1;
        }
      }
    }
  }
  
  final static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    matrix = new int[N][M];
    
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    for (int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(matrix[i][j] != 1) {
          check(new Point(j, i));
        }
      }
    }
    
    System.out.println(result);
  }
}

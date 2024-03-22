import java.util.*;
import java.awt.Point;
import java.io.*;

class Main {
  static int N;
  static boolean[][] matrix;
  
  final static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
  
  static boolean inRange(Point p) {
    return 0<=p.x&&p.x<N && 0<=p.y&&p.y<N;
  }
  
  static int BFS(Point start) {
    int cnt = 0;
    Queue<Point> queue = new LinkedList<>();
    queue.add(start);
    matrix[start.y][start.x] = false; 
    
    while(!queue.isEmpty()) {
      Point p = queue.poll();
      cnt++;
      for(int[] d:deltas) {
        Point np = new Point(p.x+d[0], p.y+d[1]);
        if(inRange(np) && matrix[np.y][np.x]) {
          queue.add(np);
          matrix[np.y][np.x] = false; 
        }
      }
    }
    return cnt;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.parseInt(br.readLine());
    matrix = new boolean[N][N];
    List<Integer> list = new ArrayList<>();
    
    for(int i=0; i<N; i++) {
      char[] cs = br.readLine().toCharArray();
      for(int j=0; j<N; j++) {
        matrix[i][j] = cs[j]=='1';
      }
    }
    
    for (int i=0; i<N; i++) {
      for(int j=0; j<N; j++) {
        if(matrix[i][j]) {
          list.add(BFS(new Point(j, i)));
        }
      }
    }

    list.sort(null);
    
    System.out.println(list.size());
    for(int cnt:list) {
      System.out.println(cnt);
    }
  }
}

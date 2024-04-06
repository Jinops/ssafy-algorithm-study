import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
  int y;
  int x;
  int cost;
  
  public Point(int y, int x, int cost) {
    super();
    this.y = y;
    this.x = x;
    this.cost = cost;
  }

  @Override
  public int compareTo(Point o) {
    return this.cost - o.cost;
  }
}

public class Main {
  static int N;
  static Point[][] matrix;
  
  static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
  static boolean inRange(int y, int x) {
    return 0<=y&&y<N && 0<=x&&x<N;
  }
  static List<Point> getNextPoints(Point p) {
    List<Point> nextPoints = new LinkedList<>();
    
    for(int[] d:deltas) {
      int ny = p.y+d[0];
      int nx = p.x+d[1];
      if(inRange(ny, nx)) {
        nextPoints.add(matrix[ny][nx]);
      }
    }
    
    return nextPoints;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int pNum = 1;
    N = Integer.parseInt(br.readLine());
    while(N != 0) {
      matrix = new Point[N][N];
      boolean[][] visited = new boolean[N][N];
      int[][] costs = new int[N][N];
      
      for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
          int cost = Integer.parseInt(st.nextToken());
          matrix[i][j] = new Point(i, j, cost);
          costs[i][j] = Integer.MAX_VALUE;
        }
      }
      
      costs[0][0] = matrix[0][0].cost;
      
      PriorityQueue<Point> pq = new PriorityQueue<>();
      pq.add(matrix[0][0]);
      
      while(!visited[N-1][N-1]) {
        Point p = pq.poll();
        
        if(visited[p.y][p.x]) continue;
        visited[p.y][p.x] = true;
        
        for(Point np:getNextPoints(p)) {
          if(visited[np.y][np.x]) continue;
          int nCost = costs[p.y][p.x] + np.cost;
          if(nCost < costs[np.y][np.x]) {
            costs[np.y][np.x]= nCost;
            
            pq.add(new Point(np.y, np.x, nCost));
          }
        }
      }
      System.out.printf("Problem %d: %d\n", pNum++, costs[N-1][N-1]);
      
      N = Integer.parseInt(br.readLine());
    }
  }
}

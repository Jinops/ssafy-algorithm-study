import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
  static final int[][] deltas = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
  
  static boolean inRange(Point p, int W, int H) {
    return 0<=p.x&&p.x<W && 0<=p.y&&p.y<H;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken());
      int H = Integer.parseInt(st.nextToken());
      
      if(W==0 && H==0) {
        break;
      }
      
      int result = 0;
      int[][] matrix = new int[H][W];
      for(int h=0; h<H; h++) {
        st = new StringTokenizer(br.readLine());
        for(int w=0; w<W; w++) {
          matrix[h][w] = Integer.parseInt(st.nextToken());
        }
      }
      
      for(int h=0; h<H; h++) {
        for(int w=0; w<W; w++) {
          if(matrix[h][w]==1) {
            result++;
            // DFS
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(w, h));
            
            while(!queue.isEmpty()) {
              Point p = queue.poll();
              for(int[] delta:deltas) {
                Point np = new Point(p.x+delta[0], p.y+delta[1]);
                if(inRange(np, W, H) && matrix[np.y][np.x]==1) {
                  queue.add(np);
                  matrix[np.y][np.x] = 0; 
                }
              }
            }
            ////
          }
        }
      }
      System.out.println(result);
    }
  }
}

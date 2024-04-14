import java.util.*;
import java.io.*;

// 1. for문 돌아서 4개 연결 확인
// 2. 현재 단계에서 없어질 뿌요(그룹) 다 확인한 후, 연쇄 시작
// 3. 가장 아래 뿌요부터 확인하여, 중력으로 내려오기
// 4. 1부터 다시 반족

class Point {
  int y;
  int x;
  
  public Point(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

class Main {
  static char[][] mtx;
  static int[][] ds = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
  
  static boolean inRange(Point p) {
    return 0<=p.y&&p.y<12 && 0<=p.x&&p.x<6;
  }
  
  static boolean remove() {
    boolean[][] visited = new boolean[12][6];
    boolean isChanged = false;
    
    for(int i=11; i>=0; i--) {
      for(int j=0; j<6; j++) {
        if(mtx[i][j]!='.' && !visited[i][j]) {
          // 방문하지 않은 뿌요에 대해
          Queue<Point> queue = new LinkedList<>();
          List<Point> points = new ArrayList<>();
          
          queue.add(new Point(i, j));
          visited[i][j] = true;
          
          while(!queue.isEmpty()) {
            Point p = queue.poll();
            points.add(p);
            
            for(int[] d:ds) {
              Point np = new Point(p.y+d[0], p.x+d[1]);
              if(inRange(np) && mtx[np.y][np.x]==mtx[i][j] && !visited[np.y][np.x]) {
                visited[np.y][np.x] = true;
                queue.add(np);
              }
            }
          }
          
          if(points.size()>=4) {
            // 뿌요를 부쉰다
            isChanged = true;
            for(Point p:points) {
              mtx[p.y][p.x] = '.'; 
            }
          }
        }
      }
    }
    
    return isChanged;
  }
  
  static void fallDown() {
    for(int i=10; i>=0; i--) {
      for(int j=0; j<6; j++) {
        if(mtx[i][j]!='.') {
          int nextI = i+1;
          while(nextI<12 && mtx[nextI][j] == '.'){
            mtx[nextI][j] = mtx[nextI-1][j];
            mtx[nextI-1][j] = '.';
            nextI++;
          }
        }
      }
    }
  }
  
  static void print() {
    for(char[] a:mtx) System.out.println(Arrays.toString(a));
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    mtx = new char[12][6];
    for(int i=0; i<12; i++) {
      mtx[i] = br.readLine().toCharArray();
    }
    
    int cnt = 0;
    while(remove()) {
      cnt++;
      fallDown();
    }
    
    System.out.println(cnt);
  }
}

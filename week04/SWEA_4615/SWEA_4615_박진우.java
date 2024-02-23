import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int M;
    static int[][] map;
    
    static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    
    static void fill(int[][] map, ArrayList<Point> targets, int color) {
      for(Point p:targets) {
        map[p.y][p.x] = color; 
      }
    }
    static void game(int[][] map, int x, int y, int color) {
        map[y][x] = color;
        
        for(int[] delta:deltas) {
          int nx = x+delta[1];
          int ny = y+delta[0];
          ArrayList<Point> targets = new ArrayList<>();
          
          while(0<=nx&&nx<N && 0<=ny&&ny<N && map[ny][nx]!=0) {
            if(map[ny][nx] == color){
              fill(map, targets, color);
              break;
            }
            targets.add(new Point(nx, ny));
            nx += delta[1];
            ny += delta[0];
          }
        }
    }
    
    static int[] getCounts(int[][] map) {
        int[] counts = new int[2];
        for(int[] line:map) {
            for(int color:line) {
                if(color==1) counts[0]++;
                if(color==2) counts[1]++;
            }
        }
        return counts;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            map[N/2-1][N/2-1] = 2;
            map[N/2-1][N/2] = 1;
            map[N/2][N/2-1] = 1;
            map[N/2][N/2] = 2;
            
            for(int m=1; m<=M; m++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                game(map, x-1, y-1, color);
                
            }
            
            int[] counts = getCounts(map);
            System.out.printf("#%d %d %d\n", t, counts[0], counts[1]);
        }
    }
}

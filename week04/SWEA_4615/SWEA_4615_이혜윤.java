package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 재미있는오셀로게임_4615 {
    static int[][] map;
    static int N;
    static int white=0, black=0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            white=0; 
            black=0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
 
            map = new int[N + 1][N + 1]; // 1-based
            getStart();
 
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                playGame(y, x, color);
            }
            sb.append("#"+t+" "+black+" "+white+"\n");
        }
        System.out.println(sb);
    }
     
    static void getStart() {
        map[N/2][N/2] =2;
        map[N/2+1][N/2+1]=2;
        white+=2 ;
         
        map[N/2][N/2+1]=1;
        map[N/2+1][N/2]=1;
        black+=2;
    }
     
    static void playGame(int y, int x, int color) {
        int dy[] = {-1,1,0,0,-1,-1,1,1};
        int dx[] = {0,0,-1,1,-1,1,-1,1};
         
        for(int i=0; i<8; i++) {
            int ny = y+ dy[i];
            int nx = x + dx[i];
             
            while(!isOut(ny, nx)) {
                if(map[ny][nx]==color) { // 지금 놓는 돌과 같은 컬러라면
                    while(true) {
                        // 이미 놓여있는 돌 중 지금 놓는 돌과 색깔이 같으면서도, 가장 가까운 돌 사이에 있는 다른 돌들을 검사
                        ny -= dy[i]; 
                        nx -= dx[i];
                         
                        if(y==ny && x ==nx) break; // 지금 놓는 돌과 같은 위치까지 왔으면 검사 중단 
                        map[ny][nx]=color; // 색깔 바꿔야하는 돌 색깔 바꾸기
                         
                        if(color==1) {
                            black++;
                            white--;
                        } else {
                            black--;
                            white++;
                        }
                    }
                    break;
                } else if(map[ny][nx]==0) { // 색칠되지 않은 칸이면 더 전진하지 않고 패스
                    break;
                } 
                // 해당 방향으로 더 진행
                ny+=dy[i];
                nx+=dx[i];
            }
        }
        // 이러나저러나 원래 입력받은 위치에 돌은 놓아야하니까
        setStone(y,x,color);
    }
     
 
    static void setStone(int y, int x, int color) {
        map[y][x]=color; // 색깔 바꿔야하는 돌 색깔 바꾸기
        if(color==1) { // 흑돌 추가
            black++;
        } else { // 백돌 추가
            white++;
        }
    }
     
    static boolean isOut(int y, int x) {
        if(y<=0 || x<=0 || y>N || x>N) return true;
        return false;
    }
}
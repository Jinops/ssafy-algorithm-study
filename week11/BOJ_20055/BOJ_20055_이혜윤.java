package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {

    static int N, K, left, right;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N];
        robot = new boolean[2*N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<2*N; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }
        left =0; right = N;

        int cnt = 0;
        while(K > 0) {
            cnt++;
            moveBelt(); // 벨트를 한 칸 회전
            moveRobot(); // 로봇을 이동
            newRobot(); // 새로운 로봇을 올림
        }
        System.out.println(cnt);
    }

    static void moveBelt(){
        left--; right--;
        if(left==-1) left = 2*N-1;
        if(right==-1) right = 2*N-1;
        
     // 로봇이 상단 벨트의 끝에 도달하면 내려감
        for(int i=N-2; i>=0; i--){
            if(robot[i]){
                robot[i]=false;
                if(i+1 < N-1) robot[i+1] = true;
            }
        }
    }

    static void moveRobot(){
        for(int i=N-2; i>=0; i--){
            // 컨베이어 벨트의 회전으로 인해, 벨트의 상단 시작점(left)이 변화하므로,
            // 로봇의 실제 위치를 계산할 때는 left 값을 기준으로 현재 로봇의 위치(i)에 1을 더해 다음 위치를 계산
            int nextPos = (left + i+1)%(2*N);
            if(robot[i] && !robot[i+1] && belt[nextPos] > 0){
                robot[i] = false;
                if(i+1 < N-1) { 
                	// 상단 벨트의 마지막 위치에서는 로봇을 이동시키지 않음
                	// 다음 턴에 moveBelt()로 인해 하단 벨트로 내려가게 됨
                    robot[i+1] = true;
                }
                belt[nextPos]--;
                if(belt[nextPos] == 0) K--;
            }
        }
        // 컨베이어 벨트의 회전으로 인해 로봇이 마지막 위치에 도달했을 경우, 로봇을 제거
        if(robot[N-1]) {
            robot[N-1] = false;
        }
    }
    
    static void newRobot() {
    	if(!robot[0] && belt[left]>0) {
    		robot[0] = true;
    		belt[left]--;
    		if(belt[left]==0) K--;
    	}
    }
}

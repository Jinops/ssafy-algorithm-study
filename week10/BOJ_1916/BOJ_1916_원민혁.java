import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Integer[][] busCost = new Integer[cityNum+1][cityNum+1];
//        for (int i = 1; i < cityNum+1; i++) {
//            for (int j = 1; j < cityNum+1; j++) {
//                busCost[i][j] = -1;
//            }
//        }
        for (int i = 0; i < busNum; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 버스 출발 도시
            int c = Integer.parseInt(st.nextToken()); // 버스 도착 도시
            int cost = Integer.parseInt(st.nextToken()); // 버스비
            if (busCost[r][c] == null)
                busCost[r][c] = cost;
            else
                busCost[r][c] = Math.min(cost, busCost[r][c]);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        Integer[] cities = new Integer[cityNum+1];
//        for (int i = 1; i < cityNum+1; i++) {
////            cities[i] = -1;
////        }
        cities[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < cityNum+1; i++) {
            if (busCost[start][i] != null && i != start) {
                cities[i] = busCost[start][i];
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                start = queue.poll();
                for (int j = 1; j < cityNum+1; j++) {
                    if (busCost[start][j] != null && i != start) { // 가는 버스가 있다
                        if (cities[j] == null) { // 도착 도시에 들린 적이 없다
                            cities[j] = cities[start] + busCost[start][j];
                            queue.offer(j);
                        } else { // 도착 도시에 들린 적이 있다
                            if (cities[start]+busCost[start][j] < cities[j]) { // 이번에 가는 게 더 싸다
                                cities[j] = cities[start] + busCost[start][j];
                                queue.offer(j);
                            }
                        }
                    }
                }
            }
        }
        System.out.print(cities[goal]);
    }
}
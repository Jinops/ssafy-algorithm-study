package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장_1952 {
	static int minCost;
	static int[] cost;
	static int[] plan;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			cost = new int[4];
			plan = new int[12];
			for(int i=0; i<4; i++) {
				cost[i] = Integer.parseInt(st1.nextToken());
			}
			for(int i=0; i<12; i++) {
				plan[i] = Integer.parseInt(st2.nextToken());
			}
			
			minCost = cost[3];
			getCost(0,0);
			
			sb.append("#"+t+" "+minCost+"\n");
		}
		System.out.println(sb);
	}
	
	static void getCost(int monthIdx, int sumCost) {
		//base
		if(monthIdx>=12) {
			minCost = Math.min(minCost, sumCost);
			return;
		}
		
		//recursive
		if(plan[monthIdx]>0) { //이번 달 이용 계획이 있는 경우
			// 1일 이용권
			getCost(monthIdx+1, sumCost+ cost[0] * plan[monthIdx]);
			
			// 1달 이용권
			getCost(monthIdx+1, sumCost+cost[1]);
			
			// 3달 이용권
			getCost(monthIdx+3, sumCost+cost[2]);	
		} else { // 이번 달 이용 계획이 없는 경우
			getCost(monthIdx+1, sumCost);
		}
	}
	

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Road {
	int to;
	int weight;
	
	public Road(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

public class 중량제한 {
	
	static int answer;
	static List<Road>[] roadList;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		roadList = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			roadList[i] = new ArrayList<>();
		}
		
		int left =0;
		int right =0;
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			roadList[a].add(new Road(b, w));
			roadList[b].add(new Road(a, w));
			right = Math.max(right, w); 
		}
		
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		while(left <= right) {
			int mid = (left+right)/2;
			answer = -1;
			check = new boolean[N+1];
			dfs(from, to, mid);
			if(answer!=-1) left = mid+1;
			else right = mid-1;
		}
		System.out.println(right);	
	}
	
	static void dfs(int cur, int target, int limit) {
		if(cur==target) {
			answer = cur;
			return;
		}
		check[cur]=true;
		for(Road r : roadList[cur]) {
			if(!check[r.to] && limit <= r.weight) {
				dfs(r.to, target, limit);
			}
		}
		
	}
}

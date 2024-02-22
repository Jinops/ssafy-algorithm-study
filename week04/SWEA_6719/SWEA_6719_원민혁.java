package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_6719_성수의프로그래밍강좌시청 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Queue<Integer> lessons = new PriorityQueue<Integer>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				lessons.offer(Integer.parseInt(st.nextToken()));
			}
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < K; i++) {
				stack.push(lessons.poll());
			}
			double skill = 0;
			for (int i = 0; i < K; i++) {
				skill = (skill + stack.pop()) / 2.0; 
			}
			sb.append("#"+t+" "+skill+"\n");
		}
		System.out.println(sb);
	}
}

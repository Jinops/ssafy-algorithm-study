package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2343_기타_레슨 {

	static int N, M;
	static long sum;
	static int cnt;
	static ArrayList<Integer> list;
	static long max, min, mid;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		max = min = 0;
		for (int i = 0; i < N; i++) {
			
			list.add(Integer.parseInt(st.nextToken()));
			max += list.get(i);
			
			if (min < list.get(i))
				min = list.get(i);
		}	// i에 대한 for문
		
		while (max >= min) {
			
			mid = (max + min) / 2;
			
			sum = 0;
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				
				if (sum + list.get(i) > mid) {
					cnt++;
					sum = 0;					
				}
				
				sum += list.get(i);
			}
			
			if (sum != 0) cnt++;
			
			if (cnt <= M) max = mid - 1;
			else min = mid + 1;			
		}	// while문
		
		System.out.println(min);
	}	// main
}

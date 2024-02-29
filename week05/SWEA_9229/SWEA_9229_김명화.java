package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229_김명화 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int[] snacks = new int[N];

			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st2.nextToken());
			}
			
			Arrays.sort(snacks);
			int n = snacks.length;
			int[] weight = new int[snacks[n-2]+snacks[n-1]+1]; // 두 개의 최대합
			
			for(int i=0; i<snacks.length; i++) {
				int rest = M - snacks[i];
				if(rest<=0) break;
				
				for(int j=snacks.length-1; j>i; j--) {
					if(snacks[j]<=rest) {
						weight[snacks[i]+snacks[j]]++;
					}
				}
			}
			int maxSum = -1;		
			
			for(int i=weight.length-1; i>=1; i--) {
				if(weight[i]!=0) {
					maxSum = i;
					break;
				}
			}
			System.out.printf("#%d %d%n", TC, maxSum);
		}

	}

}
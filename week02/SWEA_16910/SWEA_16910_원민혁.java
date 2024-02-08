package algorithm_prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_16910_원안의점 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int r = Integer.parseInt(br.readLine());
			int count = 0;
			
			for(int x = 1; x <= r; x++) {
				for(int y = 1; y <= r; y++) {
					if (x*x+y*y <= r*r) {
						count++;
					} else {
						break;
					}
				}
			}
			count *= 4;
			count += 4*r+1;
			sb.append("#"+t+" "+count+"\n");
		}
		System.out.println(sb);
	}
}

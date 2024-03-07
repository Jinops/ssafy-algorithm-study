package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 새샘이와세소수_5986 {
	
	static ArrayList<Integer> prime = new ArrayList<>();
	static boolean[] isPrime = new boolean[1000];
	static int[] primeSum = new int[3000];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		setPrime();
		getSum();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append("#"+t+" "+primeSum[N]+"\n");
		}
		System.out.println(sb);
	}
	
	static void setPrime() {
		for(int i=2; i<Math.sqrt(isPrime.length); i++) {
			if(!isPrime[i]) continue;
			// i가 소수일 때만 아래 코드 실행
			for(int j = i+i; j<isPrime.length; j+=i) {
				isPrime[j] = false;
			}
		}
		
		for(int i=0; i<isPrime.length; i++) {
			if(isPrime[i]) prime.add(i);
		}
	}
	
	static void getSum() {
		for(int i=0; i<prime.size(); i++) {
			for(int j=i; j<prime.size(); j++) {
				for(int k=j; k<prime.size(); k++) {
					primeSum[prime.get(i)+prime.get(j)+prime.get(k)]++;
				}
			}
		}
	}
}

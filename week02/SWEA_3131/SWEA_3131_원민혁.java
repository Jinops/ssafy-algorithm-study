package algorithm_prac;

public class SWEA_3131_100만이하의모든소수 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		boolean[] countPrime = new boolean[1000001];
		
		for(int i = 2; i <= 1000000; i++) {
			for(int j = 2; j <= 1000000/i; j++) {
				countPrime[i*j] = true;
			}
		}
		for(int i = 2; i <= 1000000; i++) {
			if(!countPrime[i])
				sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}

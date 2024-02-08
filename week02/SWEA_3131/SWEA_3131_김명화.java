
public class SWEA_3131_김명화 {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=2; i<=1000000; i++) {
			
			if(isPrime(i)) {
				sb.append(i).append(' ');
			}
			
		}
		
		System.out.println(sb);

		
	}

	public static Boolean isPrime(int num) {
		
		if(num < 2) {
			return false;
		}
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
		
	}
}
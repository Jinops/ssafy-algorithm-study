import java.util.ArrayList;
import java.util.List;

public class SWEA_3131 {
	public static void main(String[] args) {
		
		List<Boolean> primeNum = new ArrayList<>();
		
		primeNum = findPrimeNumber(1000000);
		for (int i = 0; i < primeNum.size(); i++) {
			if (primeNum.get(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	
	
	public static List<Boolean> findPrimeNumber(int num) {
		List<Boolean> primeNum = new ArrayList<>();
		
		// 0이랑 1은 소수가 아니므로 false
		primeNum.add(false);
		primeNum.add(false);
		
		// 합성수를 거르는 과정은 소수의 배수만 찾으면 된다.
		// 따라서 합성수인 경우는 if문이 실행되지 않도록 해주기 위해서
		// 리스트의 기본값들을 모두 true로 설정하고
		// 합성수인 경우만 false로 바꿔주는 방법으로 진행
		for (int i = 2; i < num + 1; i++) {
			primeNum.add(true);
		}
		
		for (int i = 2; i < Math.sqrt(num); i++) {
			// i의 배수들을 찾아야하니 j++할 필요 없이 j += i
			for (int j = i * i; j < num + 1; j += i) {
				// primeNum리스트가 Boolean타입만 받으므로
				// j인덱스에 해당하는 값이 합성수라서 false처리되면 
				// j의 배수들은 합성수이므로 조사할 필요가 없다.
				if (primeNum.get(j)) {
					primeNum.set(j, false);
				}
			}
		}
		
		return primeNum;
	}
}

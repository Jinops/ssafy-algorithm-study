package swea;

public class SWEA_3131_이혜윤 {
	public static void main(String[] args) {
		for (int i = 2; i < 1000000; i++) {
			int flag = 0;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) { // flag==0이면 소수
				System.out.print(i + " ");
			}
		}

	}
}

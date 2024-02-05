import java.util.stream.IntStream;

public class SWEA_3131_배준영 {
	public static void main(String[] args) {


		int[] nums = IntStream.rangeClosed(2, 1000000).toArray();
		int N = (int) Math.sqrt(1000000);
		
		for(int i=2; i<N; i++) {
			int j = 2;
			while(i*j <= 1000000) {
				nums[i*j-2] = 0;
				j++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<nums.length; i++) {
			if(nums[i]!=0) {
				sb.append(nums[i] + " ");
			}
		}
		System.out.println(sb);

	}
}
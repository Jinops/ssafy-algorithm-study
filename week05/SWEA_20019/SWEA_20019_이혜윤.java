package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문의회문_20019 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        TC: for (int t = 1; t <= T; t++) {
            sb.append("#" + t + " ");
            String str = br.readLine();
            int N = str.length();
            boolean flag;
            
            flag = isPalindrome(str);
            if (!flag) {
                sb.append("NO" + "\n");
                continue TC;
            }
            flag = isPalindrome(str.substring(0, N / 2));
            if (!flag) {
                sb.append("NO" + "\n");
                continue TC;
            }
            flag = isPalindrome(str.substring(N / 2+1));
            if (!flag) {
                sb.append("NO" + "\n");
                continue TC;
            }
            sb.append("YES" + "\n");

        }
        System.out.println(sb);
    }

    static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}

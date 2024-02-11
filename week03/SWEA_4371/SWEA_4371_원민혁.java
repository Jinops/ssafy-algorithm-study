import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4371_항구에들어오는배 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int N = Integer.parseInt(br.readLine());
            int day1 = Integer.parseInt(br.readLine());
            int[] gaps = new int[N-1];
            for (int i = 0; i < N-1; i++) {
                gaps[i] = Integer.parseInt(br.readLine()) - day1;
            }

            Boolean[] isBoat = new Boolean[N-1];
            int count = 0;
            for (int i = 0; i < N-1; i++) {
                if (isBoat[i] == null) {
                    isBoat[i] = true;
                    count++;
                    for (int j = i + 1; j < N - 1; j++) {
                        if (gaps[j] % gaps[i] == 0)
                            isBoat[j] = false;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}

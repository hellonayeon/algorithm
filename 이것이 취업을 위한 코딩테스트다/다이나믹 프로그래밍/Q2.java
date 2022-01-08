import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] dp = new int[X+1];
        
        for(int i=2; i<=X; i++) {
            dp[i] = dp[i-1] + 1;

            if(i%2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(i%3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
            if(i%5 == 0) {
                dp[i] = Math.min(dp[i], dp[i/5] + 1);
            }
        }
        System.out.println(dp[X]);
    }
}
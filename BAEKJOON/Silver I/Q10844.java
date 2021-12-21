import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][12];
        for(int i=2; i<=10; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=1; j<=10; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        long ans = 0;
        for(int i=1; i<=10; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans % 1000000000);
    }
}
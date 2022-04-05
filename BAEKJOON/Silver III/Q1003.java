import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1003 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        
        dp = new int[41][2];
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        dp[2][0] = 1; dp[2][1] = 1;
        dp[3][0] = 1; dp[3][1] = 2;
        
        for (int i=0; i<tc; i++) {
            int N = Integer.parseInt(br.readLine());

            countZeroAndOne(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        System.out.println(sb);
    }

    public static void countZeroAndOne(int fiboN) {
        for (int i=4; i<=fiboN; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
    }
}

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Q11050 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K+1];

        System.out.println(binoCoef(N, K));
    }

    public static int binoCoef(int n, int k) {
        if(dp[n][k] > 0) {
            return dp[n][k];
        }

        if(k == 0 || n == k) {
            return dp[n][k] = 1;
        }

        return dp[n][k] = binoCoef(n-1, k) + binoCoef(n-1, k-1);
    }
}
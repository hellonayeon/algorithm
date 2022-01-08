import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Arrays;


class Q5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] money = new int[N];
        int[] dp = new int[M+1];
        Arrays.fill(dp, 10001);

        // 화폐 리스트
        for(int i=0; i<N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        for(int i=0; i<N; i++) {
            for(int j=money[i]; j<=M; j++) {
                // i: 현재 금액(현재 인덱스)
                // k: 화폐 단위
                // (i-k)원을 만드는 방법이 존재하는 경우
                if(dp[j - money[i]] != 10001) { // if문 생략 가능
                    dp[j] = Math.min(dp[j], dp[j - money[i]] + 1);
                }
            }
        }

        if(dp[M] == 10001) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[M]);
        }
    }
}
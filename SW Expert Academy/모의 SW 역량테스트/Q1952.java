
/**
 * SW Expert Academy 모의 SW 역량테스트
 * 1952번 수영장
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.io.FileInputStream;

class Q1952 {

    static int[] fee = new int[4]; // 1일, 1달, 3달, 1년 요금
    static int[] dp = new int[13];

    static int res;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q1952_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 요금 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<4; i++) {
                fee[i] = Integer.parseInt(st.nextToken());
            }

            // 1년 이용 계획 입력
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=12; i++) {
                // 이용일
                int days = Integer.parseInt(st.nextToken());

                // 1일 이용권과 1달 이용권 요금 비교
                dp[i] = Math.min(dp[i-1] + days*fee[0], dp[i-1] + fee[1]);
                
                // 3달 이용권 요금 비교
                // 3달 이전까지의 최소 요금 + 현재 구한 3달 요금
                // 1, 2월인 경우 (i=1, i = 2) 이 분기는 고려하지 않아도 돼
                // why? 문제의 조건에서 12, 1, 2월의 경우는 불가능하다 했으니까
                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i-3] + fee[2]);
                }
            }

            sb.append("#").append(tc).append(" ").append(Math.min(dp[12], fee[3])).append("\n");
        }

        System.out.println(sb);
    }
}

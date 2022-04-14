
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
    static int[] plan = new int[13];

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
                plan[i] = Integer.parseInt(st.nextToken());
            }

            res = fee[3]; // 초기 최소 비용
            dfs(1, 0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int month, int sum) {
        if (sum >= res) return;

        if (month > 12) {
            res = Math.min(res, sum);
            return;
        }

        if (plan[month] == 0) {
            dfs(month + 1, sum);
        }
        else {
            // 1일 이용 요금
            dfs(month + 1, sum + fee[0]*plan[month]);

            // 1달 이용 요금
            dfs(month + 1, sum + fee[1]);
            
            // 3달 이용 요금
            dfs(month + 3, sum + fee[2]);
        }
    }
}

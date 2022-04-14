
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

    static int[] fee = new int[4]; // 1일, 1개월, 3개월, 1년 요금
    static int[] plan = new int[12];
    static int[] cost = new int[12];
    static boolean[] cnt3Month = new boolean[12];

    static int minFee = 3600;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q1952_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            inputPrice(br);
            inputPlan(br);


        }


    }

    private static void inputPrice(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            fee[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void inputPlan(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 12; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int calcTotalFee() {
        int totalFee = 0;
        for (int i=0; i<12; i++) {
            totalFee += cost[i];
        }

        return totalFee;
    }

    private static void useOneDayPass() {
        for (int i=0; i<12; i++) {
            cost[i] = plan[i] * fee[0];
        }

        Math.min(minFee, calcTotalFee());
    }

    private static void useOneMonthPass() {
        for (int i=0; i<12; i++) {
            if (cost[i] > fee[1]) {
                cost[i] = fee[1];
            }
        }

        Math.min(minFee, calcTotalFee());
    }

    private static void useThreeMonthPass() {
        /* 3달 이용권의 개수는 최소 0개, 최대 4개 */
        // 1~3개의 경우의 수
    }

    private static void useOneYearPass() {
        Math.min(minFee, fee[3]);
    }
}

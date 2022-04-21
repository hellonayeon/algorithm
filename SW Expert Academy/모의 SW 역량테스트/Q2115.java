import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

import java.io.FileInputStream;

class Q2115 {

    static int N;
    static int M;
    static int C;
    static int[][] map;
    static int[][] dp;
    static int res;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q2115_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            map = new int[N][N];
            dp = new int[N][N-M+1];

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<N-M+1; j++) {
                    int[] unit = Arrays.copyOfRange(map[i], j, j+M);
                    boolean[] chk = new boolean[M];
                    getMaxHoney(unit, chk, 0, 0, 0, i, j);
                }
            }
            
            res = 0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N-M+1; j++) {
                    getMaxRevenue(i, j, i, j);
                }
            }
            

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }

    /**
     * @param unit      연속된 M개의 벌통
     * @param chk       체크 여부
     * @param sum       누적된 꿀의 양
     * @param square    누적된 수익
     * @param idx       다음 방문할 인덱스
     * @param di        
     * @param dj        
     */
    private static void getMaxHoney(int[] unit, boolean[] chk, int sum, int square, int depth, int di, int dj) {
        if (sum > C || depth > M) {
            return;
        }

        dp[di][dj] = Math.max(square, dp[di][dj]);

        for (int i=0; i<M; i++) {
            if (!chk[i]) {
                chk[i] = true;
                getMaxHoney(unit, chk, sum + unit[i], square + (unit[i]*unit[i]), depth+1, di, dj);
                chk[i] = false;
            }
        }
    }

    private static void getMaxRevenue(int si, int sj, int ni, int nj) {
        if (ni >= N) {
            return;
        }

        if (si == ni) {
            nj += M;
        }
        else {
            nj += 1;
        }

        if (nj >= N - M + 1) {
            getMaxRevenue(si, sj, ni+1, -1);
        }
        else {
            res = Math.max(dp[ni][nj] + dp[si][sj], res);
            getMaxRevenue(si, sj, ni, nj);
        }
    }
}
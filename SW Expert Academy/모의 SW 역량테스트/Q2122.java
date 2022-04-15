import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.FileInputStream;

class Q2122 {

    static int D;
    static int W;
    static int K;
    static int[][] film; // 0(A), 1(B)
    static int res;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q2122_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];

            for (int r=0; r<D; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c=0; c<W; c++) {
                    film[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            res = Integer.MAX_VALUE;
            injection(0, 0);
            
            res = (res == Integer.MAX_VALUE) ? 0 : res;
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.println(sb);
    }

    private static void injection(int depth, int cnt) {
        if (cnt >= res) {
            return;
        }

        if (depth == D) {
            if (check()) {
                res = Math.min(res, cnt);
            }
            return;
        }

        int[] tmp = film[depth].clone();

        // 약물을 투입하지 않는 경우
        injection(depth + 1, cnt);

        // A 약물을 투입하는 경우
        Arrays.fill(film[depth], 0);
        injection(depth + 1, cnt + 1);

        // B 약물을 투입하는 경우
        Arrays.fill(film[depth], 1);
        injection(depth + 1, cnt + 1);

        film[depth] = tmp;
    }

    private static boolean check() {
        loop: 
        for (int c=0; c<W; c++) {
            int cnt = 1; // 동일한 특성의 연속된 셀 개수
            for (int r=1; r<D; r++) {
                // 동일한 특성의 연속된 셀 개수 카운팅
                if (film[r-1][c] == film[r][c]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                // 연속된 동일한 특성 셀의 수가 K 이상이면 다음 열 검사
                if (cnt >= K) {
                    continue loop;
                }
            }
            return false;
        }
        return true;
    }
}
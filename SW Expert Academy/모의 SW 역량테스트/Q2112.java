import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.io.FileInputStream;

import java.util.Arrays;

class Q2117 {

    static int[][] film; // A = 0, B = 1
    static int K;
    static int D;
    static int W;
    
    static int res;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q2112_input.txt"));

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

            res = D;
            inject(0, 0);

            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static void inject(int depth, int cnt) {
        if (cnt >= res) {
            return;
        }
        if (depth == D) {
            if (check()) {
                res = Math.min(cnt, res);
            } 
            return;
        }

        int[] tmp = film[depth].clone();

        // 약물을 투약하지 않는 경우
        inject(depth + 1, cnt);

        // A 약물을 투약하는 경우
        Arrays.fill(film[depth], 0);
        inject(depth + 1, cnt + 1);

        // B 약물을 투약하는 경우
        Arrays.fill(film[depth], 1);
        inject(depth + 1, cnt + 1);
        
        film[depth] = tmp;
    }

    private static boolean check() {
        for (int c=0; c<W; c++) {
            int cell = film[0][c];
            int sum = 1;
            for (int r=1; r<D; r++) {
                if (cell == film[r][c]) {
                    sum++;
                    // 다음 열 검사
                    if (sum == K) {
                        break;
                    }
                }
                else if (r+K <= D) {
                    cell = (cell == 0) ? 1 : 0;
                    sum = 1;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

import java.io.FileInputStream;

class WaterBill {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/WaterBill_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int A = P * W ;
            int B = (W <= R) ? Q : Q + (W - R) * S;

            System.out.println("#" + tc + " " + Math.min(A, B));
        }
    }
}
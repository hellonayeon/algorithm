import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

class Q11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[][] xys = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xys[i][0] = x;
            xys[i][1] = y;
        }

        Arrays.sort(xys, (e1, e2) -> {
            if(e1[1] == e2[1]) return e1[0] - e2[0];
            return e1[1] - e2[1];
        });

        for(int i = 0; i < N; i++) {
            sb.append(xys[i][0]).append(" ").append(xys[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}
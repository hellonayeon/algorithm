import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Q1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int T = 0; T < N; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            int b = Math.max(n1, n2);
            int s = (n1 + n2) - b;
            int ans = b * s / gcd(b, s);

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    public static int gcd(int a, int b) {
        if(a % b == 0) return b;
        return gcd(b, a%b);
    }
}

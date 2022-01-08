import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<N; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }

        System.out.println(dp[N-1]);
    }
}
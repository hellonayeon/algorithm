import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		
		dp[1] = arr[1];
		if (N > 1) {
			dp[2] = arr[1] + arr[2];
		}
		
        // dp[i-1]: 현재 포도주를 안 마신 경우 (마지막 포도주는 마시지 않는 경우)
        // dp[i-2] + arr[i]: 이전 이전 포도주를 마신 경우 
        // dp[i-3] + dp[i-1] + arr[i]: 이전 포도주를 마신 경우 (연속으로 2잔을 마셨으니, 이전 이전 이전 까지 확인)

		for (int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i]);
		}
		System.out.println(dp[N]);
    }
}

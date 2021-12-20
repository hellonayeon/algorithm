import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

		for (int i=0; i<=9; i++) {
			dp[1][i] = 1;
		}
		
        // 길이가 i인 숫자에서, 마지막 자릿수가 j일 경우 
        // 앞 자리에 나올 수 있는 수의 개수를 2차원 배열에 저장
        // [ex] 길이가 2이며 마지막 자릿수가 2일 경우
        //      02, 12, 22 = 총 3개
		for (int i=1; i<=N; i++) {
			dp[i][0] = 1;
			for (int j=1; j<=9; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007;
			}
		}
		
		int result = 0;
		for (int i=0; i<=9; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % 10007);
		
	}
}
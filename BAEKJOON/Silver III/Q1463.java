import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1463 {

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        
        calc(X, 0);

        System.out.println(ans);
    }

    private static void calc(int num, int cnt) {
        if (cnt >= ans)
			return;

		if (num == 1) {
            ans = Math.min(cnt, ans);
            return;
        }
			
		if (num % 2 == 0)
			calc(num/2, cnt+1);
		if (num % 3 == 0)
			calc(num/3, cnt+1);
        calc(num-1, cnt+1);
	}
}
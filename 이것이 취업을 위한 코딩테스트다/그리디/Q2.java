import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N, M, K
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        int K = Integer.parseInt(input.nextToken());

        input = new StringTokenizer(br.readLine());
        int first = 0, second = 0;
        while(N-- > 0) {
            int num = Integer.parseInt(input.nextToken());
            if(num > first) {
                second = first;
                first = num;
            }
            else if (num > second) {
                second = num;
            }
        }

        int sum = 0;
        int cnt = M/(K+1)*K + M%(K+1);

        sum += (first*cnt) + (second*(M-cnt));

        System.out.println(sum);
    }
}

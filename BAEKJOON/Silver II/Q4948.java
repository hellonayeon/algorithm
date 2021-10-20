import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num;
        while( (num = Integer.parseInt(br.readLine())) != 0) {
            sb.append(cntPrime(num)).append("\n");
        }

        System.out.print(sb);
    }

    public static int cntPrime(int n) {
        int cnt = 0;

        for(int i = n+1; i <= n*2; i++) {
            boolean isPrime = true;
            
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) cnt++;
        }

        return cnt;
    }
}
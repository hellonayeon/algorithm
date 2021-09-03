import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        if(M == 1) M += 1;
        
        int sum = 0;
        int min = 0;
        for(int i = N; i >= M; i--) {
            if(isPrime(i)) {
                sum += i;
                min = i;
            }
        }
        
        // 소수가 없는 경우
        if(sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    public static boolean isPrime(int num) {        
        for(int i = 2; i <= num/2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
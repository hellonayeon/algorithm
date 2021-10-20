import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = -1;
        for(int i = 0; i <= N/5; i++) {
            int tmp = N;
            tmp -= 5 * i;
            
            if(tmp % 3 == 0) cnt = i + (tmp / 3);
        }

        System.out.println(cnt);
    }
}
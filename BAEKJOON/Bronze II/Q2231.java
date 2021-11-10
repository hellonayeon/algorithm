import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 1000000; i++) {
            char[] chs = String.valueOf(i).toCharArray();
            int sum = i;
            for(int j = 0; j < chs.length; j++) {
                sum += chs[j] - '0';
            }

            if(sum == N) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}